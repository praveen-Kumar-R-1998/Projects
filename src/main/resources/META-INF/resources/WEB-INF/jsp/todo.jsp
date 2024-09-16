
<%@ include file="common/header.jspf"%>
<%@ include file="common/navigation.jspf"%>

<div class="container">

	<h1>Enter ToDo Details</h1>

	<form:form method="post" modelAttribute="todo">

		<!-- inside todo bean mapping description to the description below by using path -->

		<fieldset class="mb-3">
			<form:label path="description">Description</form:label>
			<form:input path="description" type="text" name="description"
				required="required" />
			<form:errors path="description" cssClass="text-warning"></form:errors>
		</fieldset>

		<fieldset class="mb-3">
			<form:label path="date">Target Date</form:label>
			<form:input path="date" type="text" name="description"
				required="required" />
			<form:errors path="date" cssClass="text-warning"></form:errors>
		</fieldset>


		<form:input path="id" type="hidden" />

		<form:input path="done" type="hidden" />

		<input type="submit" class="btn btn-success" />

	</form:form>

</div>
<%@ include file="common/footer.jspf"%>


<script type="text/javascript">
		$('#date').datepicker({
			format : 'yyyy-mm-dd',
			startDate : '-3d'
		});
	</script>


