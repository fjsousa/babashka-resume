const puppeteer = require('puppeteer');

(async () => {
  const printOptions = {
    preferCSSPageSize: true, // to set margin = 0
    scale: 0.59,
    pageRanges: '1',
  };

  const browser = await puppeteer.launch({
    args: ['--no-sandbox', '--disable-setuid-sandbox'],
  });

  const page = await browser.newPage();

  // Generate the PDF for the first page
  await page.goto('http://localhost:1337/page-one.html');
  await page.pdf({
    path: './pdf/page-one.pdf',
    ...printOptions,
  });

  // Generate the PDF for the second page
  await page.goto('http://localhost:1337/page-two.html');
  await page.pdf({
    path: './pdf/page-two.pdf',
    ...printOptions,
  });

  await browser.close();
})();
