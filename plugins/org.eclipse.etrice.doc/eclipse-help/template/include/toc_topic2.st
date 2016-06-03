<topic href="targets/eclipse-help/$url$" label="$name$">
	$if(entries)$
		$entries:{e 			| $toc_topic2(name=e.name, url=e.url, entries=e.entries)$}$
	$endif$
</topic>