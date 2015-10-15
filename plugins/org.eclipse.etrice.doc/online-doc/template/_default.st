$include/header()$

<div class="container">
	<div class="row">
		<div class="col-sm-3">
			<div id="sidebar" role="navigation">
				<ul class="nav metismenu" id="sidebarMenu">
					$toc:{e | $include/toc_menu(name=e.name, url=e.url, entries=e.entries)$}$
				</ul>
			</div>
		</div>
		<span class="version pull-right">version $version$</span></p>
		<div class="col-sm-9">
			$_content$
			<hr>
			<p><a href="#navbar">back to top</a> <span class="version pull-right">version $version$</span></p>
		</div>
	</div>
</div>

$include/footer()$