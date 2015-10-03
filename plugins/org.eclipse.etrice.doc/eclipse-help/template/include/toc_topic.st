<topic href="targets/eclipse-help/$url$" label="$name$">
	$if(entries || _contentTocs.(name))$
		$entries:{e 			| $toc_topic(name=e.name, url=e.url, entries=e.entries)$}$
		$_contentTocs.(name):{e | $toc_topic(name=e.name, url=e.url, entries=e.entries)$}$
	$endif$
</topic>