$if(entries)$
<li><a href="$url$" aria-expanded="false">$name$ <span class="fa arrow"></span></a>
	<ul class="nav" aria-expanded="false">
		$entries:{e 			| $toc_menu2(name=e.name, url=e.url, entries=e.entries)$}$
	</ul>
</li>
$else$
<li><a href="$url$">$name$</a></li>
$endif$





