<div class = "container menu">
	<ul class="nav nav-tabs nav-justified" role="tablist">
		<li class="active"><a href="#">Questions</a></li>
		<li><a href="#">Tags</a></li>
		<li><a href="#">Users</a></li>
		<li><a href="#">Unanswered</a></li>
		<li><a href="#">About Us</a></li>
		<li><a href="#">Contact Us</a></li>
	</ul>
</div>
<script>

	$('.menu li').click(function(e) {
		$('.menu li.active').removeClass('active');
			if (!$(this).hasClass('active')) {
			$(this).addClass('active');
		}
		e.preventDefault();
	});
	
</script>