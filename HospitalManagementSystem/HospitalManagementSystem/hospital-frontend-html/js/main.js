// Main JavaScript file for Hospital Management System

// Initialize on page load
document.addEventListener('DOMContentLoaded', function() {
    // Check backend connection first
    checkBackendConnection();
    
    // Add fade-in animation to cards
    const cards = document.querySelectorAll('.card');
    cards.forEach((card, index) => {
        setTimeout(() => {
            card.classList.add('fade-in');
        }, index * 100);
    });
    
    // Update navigation active state
    updateActiveNav();
    
    // Check if user is logged in
    checkAuthStatus();

    // Initialize speciality section interactions
    initSpecialities();
});

// Update active navigation link
function updateActiveNav() {
    const currentPage = window.location.pathname.split('/').pop() || 'index.html';
    const navLinks = document.querySelectorAll('.navbar-nav .nav-link');
    
    navLinks.forEach(link => {
        const href = link.getAttribute('href');
        if (href === currentPage || (currentPage === '' && href === 'index.html')) {
            link.classList.add('active');
            link.setAttribute('aria-current', 'page');
        } else {
            link.classList.remove('active');
            link.removeAttribute('aria-current');
        }
    });
}

// Check authentication status
function checkAuthStatus() {
    const user = getUser();
    const authNav = document.querySelector('.navbar-nav:last-child');
    
    if (user && authNav) {
        authNav.innerHTML = `
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="userDropdown" role="button" data-bs-toggle="dropdown">
                    <i class="bi bi-person-circle me-1"></i>${user.fullName || user.name || 'User'}
                </a>
                <ul class="dropdown-menu">
                    <li><a class="dropdown-item" href="patient-portal.html">Patient Portal</a></li>
                    <li><a class="dropdown-item" href="appointments.html">My Appointments</a></li>
                    <li><hr class="dropdown-divider"></li>
                    <li><a class="dropdown-item" href="#" onclick="logout()">Logout</a></li>
                </ul>
            </li>
        `;
    }
}

// Logout function
function logout() {
    clearAuth();
    window.location.href = 'index.html';
}

// Show loading spinner
function showLoading(element) {
    if (element) {
        element.innerHTML = `
            <div class="text-center py-5">
                <div class="spinner-border text-primary" role="status">
                    <span class="visually-hidden">Loading...</span>
                </div>
                <p class="mt-3 text-muted">Loading...</p>
            </div>
        `;
    }
}

// Show error message
function showError(element, message) {
    if (element) {
        element.innerHTML = `
            <div class="alert alert-danger alert-dismissible fade show" role="alert">
                <i class="bi bi-exclamation-triangle-fill me-2"></i>
                ${message}
                <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
            </div>
        `;
    }
}

// Show success message
function showSuccess(element, message) {
    if (element) {
        element.innerHTML = `
            <div class="alert alert-success alert-dismissible fade show" role="alert">
                <i class="bi bi-check-circle-fill me-2"></i>
                ${message}
                <button type="button" class="btn-close" data-bs-dismiss="alert"></button>
            </div>
        `;
    }
}

// Format date
function formatDate(dateString) {
    if (!dateString) return 'N/A';
    const date = new Date(dateString);
    return date.toLocaleDateString('en-US', {
        year: 'numeric',
        month: 'long',
        day: 'numeric'
    });
}

// Format time
function formatTime(timeString) {
    if (!timeString) return 'N/A';
    return timeString;
}

// Get status badge HTML
function getStatusBadge(status) {
    const statusLower = status.toLowerCase();
    let badgeClass = 'bg-secondary';
    
    if (statusLower === 'confirmed' || statusLower === 'approved' || statusLower === 'completed') {
        badgeClass = 'bg-success';
    } else if (statusLower === 'pending') {
        badgeClass = 'bg-warning';
    } else if (statusLower === 'cancelled' || statusLower === 'rejected') {
        badgeClass = 'bg-danger';
    }
    
    return `<span class="badge ${badgeClass}">${status}</span>`;
}

// Validate email
function validateEmail(email) {
    const re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return re.test(email);
}

// Validate phone
function validatePhone(phone) {
    const re = /^[+]?[(]?[0-9]{3}[)]?[-\s.]?[0-9]{3}[-\s.]?[0-9]{4,6}$/;
    return re.test(phone);
}

// Debounce function
function debounce(func, wait) {
    let timeout;
    return function executedFunction(...args) {
        const later = () => {
            clearTimeout(timeout);
            func(...args);
        };
        clearTimeout(timeout);
        timeout = setTimeout(later, wait);
    };
}

// Check backend connection (only once per session)
async function checkBackendConnection() {
    const toastElement = document.getElementById('connectionToast');
    const toastTitle = document.getElementById('connectionTitle');
    const toastMessage = document.getElementById('connectionMessage');
    const toastIcon = document.getElementById('connectionIcon');
    
    if (!toastElement) return;
    
    // Check if notification has already been shown in this session
    const connectionChecked = sessionStorage.getItem('backendConnectionChecked');
    if (connectionChecked) {
        // Hide the toast element if it was already shown
        toastElement.style.display = 'none';
        return;
    }
    
    try {
        // Create AbortController for timeout
        const controller = new AbortController();
        const timeoutId = setTimeout(() => controller.abort(), 3000);
        
        // Try to fetch from backend API
        const response = await fetch('http://localhost:8080/api/doctors', {
            method: 'GET',
            headers: {
                'Content-Type': 'application/json',
            },
            signal: controller.signal
        });
        
        clearTimeout(timeoutId);
        
        if (response.ok) {
            // Connection successful
            toastElement.classList.remove('bg-danger', 'bg-warning');
            toastElement.classList.add('bg-success', 'text-white');
            toastIcon.className = 'bi bi-wifi me-2';
            toastTitle.textContent = 'Connected';
            toastMessage.textContent = 'Successfully connected to backend server!';
        } else {
            throw new Error('Backend returned error');
        }
    } catch (error) {
        // Connection failed
        toastElement.classList.remove('bg-success', 'bg-warning');
        toastElement.classList.add('bg-danger', 'text-white');
        toastIcon.className = 'bi bi-wifi-off me-2';
        toastTitle.textContent = 'Connection Failed';
        toastMessage.innerHTML = 'Cannot connect to backend server. <br><small>Make sure backend is running on http://localhost:8080</small>';
    }
    
    // Mark as checked in session storage
    sessionStorage.setItem('backendConnectionChecked', 'true');
    
    // Show toast notification
    const toast = new bootstrap.Toast(toastElement, {
        autohide: true,
        delay: 5000 // Show for 5 seconds
    });
    toast.show();
}

// Specialities interactions
function initSpecialities() {
    const specialityCards = document.querySelectorAll('.speciality-card');
    if (specialityCards.length) {
        const observer = new IntersectionObserver(entries => {
            entries.forEach(entry => {
                if (entry.isIntersecting) {
                    entry.target.classList.add('show');
                }
            });
        }, { threshold: 0.2 });

        specialityCards.forEach(card => observer.observe(card));
    }

    const specialityModal = document.getElementById('specialityModal');
    const modalTitle = document.getElementById('specialityModalLabel');
    const modalBody = document.getElementById('specialityModalBody');

    if (specialityModal && modalTitle && modalBody) {
        specialityModal.addEventListener('show.bs.modal', event => {
            const button = event.relatedTarget;
            if (!button) return;
            const card = button.closest('.speciality-card');
            if (!card) return;

            modalTitle.textContent = card.dataset.title || 'Speciality';
            modalBody.innerHTML = card.dataset.description || '';
        });
    }
}

