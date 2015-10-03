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
		<div class="col-sm-9">
			$_content$
		</div>
	</div>
</div>  
 
$include/footer()$