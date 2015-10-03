$if(entries || _contentTocs.(name))$
<li><a href="$url$">$name$</a>
	<ul>
		$entries:{e 			| $front_toc(name=e.name, url=e.url, entries=e.entries)$}$
		$_contentTocs.(name):{e | $front_toc(name=e.name, url=e.url, entries=e.entries)$}$
	</ul>
</li>
$else$
<li><a href="$url$">$name$</a></li>
$endif$






	
