from pathlib import Path

FOOTER_LINES = [
    '    <!-- Footer -->',
    '    <footer class="site-footer pt-5 pb-4 mt-5">',
    '        <div class="container">',
    '            <div class="row g-4">',
                '                <div class="col-md-3">',
                    '                    <h6 class="footer-heading">Care Network</h6>',
                    '                    <ul class="footer-links">',
                        '                        <li><a href="#">About HMS</a></li>',
                        '                        <li><a href="#">Contact Support</a></li>',
                        '                        <li><a href="#">Hospital Locations</a></li>',
                        '                        <li><a href="#">Telemedicine</a></li>',
                    '                    </ul>',
                    '                </div>',
                    '                <div class="col-md-3">',
                    '                    <h6 class="footer-heading">Clinical Services</h6>',
                    '                    <ul class="footer-links">',
                        '                        <li><a href="#">Emergency & Trauma</a></li>',
                        '                        <li><a href="#">Appointments</a></li>',
                        '                        <li><a href="#">Funding & NGO Support</a></li>',
                        '                        <li><a href="#">Online Lab Reports</a></li>',
                    '                    </ul>',
                    '                </div>',
                    '                <div class="col-md-3">',
                    '                    <h6 class="footer-heading">Patient Tools</h6>',
                    '                    <ul class="footer-links">',
                        '                        <li><a href="#">Patient Portal</a></li>',
                        '                        <li><a href="#">Find a Doctor</a></li>',
                        '                        <li><a href="#">Ambulance Booking</a></li>',
                        '                        <li><a href="#">Pandemic Info</a></li>',
                    '                    </ul>',
                    '                </div>',
                    '                <div class="col-md-3">',
                    '                    <h6 class="footer-heading">Partner Services</h6>',
                    '                    <ul class="footer-links">',
                        '                        <li><a href="#">Corporate Health</a></li>',
                        '                        <li><a href="#">International Transfers</a></li>',
                        '                        <li><a href="#">Supplier Relations</a></li>',
                        '                        <li><a href="#">Community Programs</a></li>',
                    '                    </ul>',
                    '                </div>',
                    '            </div>',
                    '            <div class="row g-4 mt-2">',
                    '                <div class="col-12 col-lg-8 mx-auto text-center">',
                    '                    <p class="mb-1 fw-semibold text-white">Permanent Campus</p>',
                    '                    <p class="mb-2 text-white-50">688 Beribadh Road, Mohammadpur, Dhaka-1207, Bangladesh</p>',
                    '                    <p class="mb-1 fw-semibold text-white">Admissions Office</p>',
                    '                    <p class="mb-0 text-white-50">House 56, Road 4/A @ Satmasjid Road, Dhanmondi, Dhaka-1209</p>',
                    '                </div>',
                    '            </div>',
                    '            <div class="row g-4 mt-3">',
                    '                <div class="col-12 text-center">',
                    '                    <p class="mb-2 small text-white">&copy; 2025 Hospital Management System. All rights reserved.</p>',
                    '                    <p class="mb-0 small text-white">Privacy \u2022 Terms \u2022 Accessibility</p>',
                    '                </div>',
                    '            </div>',
                    '        </div>',
                    '    </footer>'
]

FOOTER_BLOCK = '\n'.join(FOOTER_LINES) + '\n'


def replace_footer(text):
    start = text.find('<!-- Footer -->')
    if start == -1:
        return text, False
    end = text.find('</footer>', start)
    if end == -1:
        return text, False
    end += len('</footer>')
    new_text = text[:start] + FOOTER_BLOCK + text[end:]
    return new_text, new_text != text


def main():
    project_root = Path(__file__).resolve().parent
    html_dir = project_root / 'hospital-frontend-html'
    updated = []
    for path in sorted(html_dir.glob('*.html')):
        original = path.read_text(encoding='utf-8')
        replaced, changed = replace_footer(original)
        if changed:
            path.write_text(replaced, encoding='utf-8')
            updated.append(path.name)
    if updated:
        print('Updated footers:', ', '.join(updated))
    else:
        print('No footer changes needed.')


if __name__ == '__main__':
    main()

