$if(_contentTocs.(name))$
<li><a href="$url$">$name$</a>
	<ul>
		$_contentTocs.(name):{e | $front_toc2(name=e.name, url=e.url, entries=e.entries)$}$
	</ul>
</li>
$else$
<li><a href="$url$">$name$</a></li>
$endif$







