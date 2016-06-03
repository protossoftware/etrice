$include/header()$

<div style="text-align:center;">
	<p><img src="images/logo/etrice-logo-interim.png"></p>
	<h1>$title$</h1>
	<p>version $version$</p>
</div>

$_content$

<ul>
	$toc:{e | $include/front_toc1(name=e.name, url=e.url)$}$
</ul>

$include/footer()$

