// countrysite
function countrysite(code)
{
  var site = new Array();
//'xx' => 'www.wego.com', 'sg' => 'www.wego.com.sg', 'au' => 'www.wego.com.au', 'id' => 'www.wego.co.id', 'in' => 'www.wego.co.in', 'my' => 'www.wego.com.my', 'ph' => 'www.wego.com.ph', 'nz' => 'www.wegotravel.co.nz', 'cn' => 'www.wego.cn', 'kr' => 'www.wego.co.kr', 'vn' => 'www.wego.vn', 'th' => 'th.wego.com', 'jp' => 'www.wegotravel.jp', 'hk' => 'www.wego.hk', 'tw' => 'www.wego.tw', 'us' => 'usa.wego.com', 'ca' => 'www.wegotravel.ca', 'br' => 'www.wegoviajar.com.br', 'ar' => 'ar.wego.com', 'mx' => 'www.wego.mx', 'cl' => 'www.wego.cl', 'co' => 'www.wego.com.co', 'uk' => 'www.wegotravel.co.uk', 'es' => 'www.wego.com.es', 'de' => 'www.wegoreise.de', 'fr' => 'www.wego.fr', 'it' => 'www.wegoviaggio.it', 'ru' => 'www.wego.com.ru', 'ie' => 'www.wego.ie', 'pt' => 'www.wego.com.pt', 'pl' =>  'www.wegoprodroz.pl', 'se' => 'www.wegoresa.se', 'za' => 'www.wego.co.za', 'tr' => 'www.wego.com.tr',

  site['xx'] = 'www.wego.com';
  site['sg'] = 'www.wego.com.sg';
  site['au'] = 'www.wego.com.au';
  site['id'] = 'www.wego.co.id';
  site['in'] = 'www.wego.co.in';
  site['my'] = 'www.wego.com.my';
  site['ph'] = 'www.wego.com.ph';
  site['nz'] = 'www.wegotravel.co.nz';
  site['cn'] = 'www.wego.cn';
  site['kr'] = 'www.wego.co.kr';
  site['vn'] = 'www.wego.vn';
  site['th'] = 'th.wego.com';
  site['jp'] = 'www.wegotravel.jp';
  site['hk'] = 'www.wego.hk';
  site['tw'] = 'www.wego.tw';

  site['us'] = 'usa.wego.com';
  site['ca'] = 'www.wegotravel.ca';
  site['br'] = 'www.wegoviajar.com.br';
  site['ar'] = 'ar.wego.com';
  site['mx'] = 'www.wego.mx';
  site['cl'] = 'www.wego.cl';
  site['co'] = 'www.wego.com.co';

  site['uk'] = 'www.wegotravel.co.uk';
  site['es'] = 'www.wego.com.es';
  site['de'] = 'www.wegoreise.de';
  site['fr'] = 'www.wego.fr';
  site['it'] = 'www.wegoviaggio.it';
  site['ru'] = 'www.wego.com.ru';
  site['ie'] = 'www.wego.ie';
  site['pt'] = 'www.wego.com.pt';
  site['pl'] = 'www.wegoprodroz.pl';
  site['se'] = 'www.wegoresa.se';

  site['za'] = 'www.wego.co.za';
  site['tr'] = 'www.wego.com.tr';

  if(site[code])
  {
    return site[code];
  } else {
    return '';
  }
}
