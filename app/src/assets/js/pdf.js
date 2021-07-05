function addScript(url) {
	var script = document.createElement('script');
	script.type = 'application/javascript';
	script.src = url;
	document.head.appendChild(script);
}

function generatePDF() {
	const element = document.getElementById("fiche");
    var opt = {
		margin:       [0.2, -1, 0, -1],
		filename:     'fiche.pdf',
		image:        { type: 'jpeg', quality: 0.98 },
		html2canvas:  { scale: 2 },
		jsPDF:        { unit: 'in', format: 'letter', orientation: 'l' }
	};
    html2pdf().set(opt).from(element).save();
}
addScript('https://raw.githack.com/eKoopmans/html2pdf/master/dist/html2pdf.bundle.js');