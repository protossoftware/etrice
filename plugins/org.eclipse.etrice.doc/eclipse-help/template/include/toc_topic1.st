<topic href="targets/eclipse-help/$url$" label="$name$">
	$if(_contentTocs.(name))$
		$_contentTocs.(name):{e | $toc_topic2(name=e.name, url=e.url, entries=e.entries)$}$
	$endif$
</topic>