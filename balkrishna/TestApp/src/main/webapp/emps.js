$(document).ready(function(){
	getEmployees();
	
	$('#srch').keyup(function(){
		var val = $('#srch').val();
		$.ajax({
			url:'EmpController',
			type:'GET',
			data:{action:'getEmp',val:val},
			dataType:'json',
			success:function(res){
						console.log(res);
						var obj='';
						$.each(res,function(res,item){
							obj+="<tr>";
							obj+="<td>"+item.id+"</td>";
							obj+="<td>"+item.name+"</td>";
							obj+="<td>"+item.salary+"</td>";
							obj+="<td>"+item.managerName+"</td>";
							obj+="</tr>";
						});
						$("#empdata").html(obj);
						new DataTable('#emptable');
					},
					error:function(){
						console.log("error");
					}
		})
	});


	$("#modalBtn").click(function(){
		$("#exampleModal").modal('show');
		getManagers();
	});
	
	$("#addEmp").click(function(){
		addEmployee();
	})
	
});

function getEmployees()
{
	$.ajax({
		url:'EmpController',
		type:'GET',
		data:{action:'getEmp'},
		dataType:'json',
		success:function(res){
			console.log(res);
			var obj='';
			$.each(res,function(res,item){
				obj+="<tr>";
				obj+="<td>"+item.id+"</td>";
				obj+="<td>"+item.name+"</td>";
				obj+="<td>"+item.salary+"</td>";
				obj+="<td>"+item.managerName+"</td>";
				obj+="</tr>";
			});
			$("#empdata").html(obj);
		    new DataTable('#emptable');
		},
		error:function(){
			console.log("error");
		}
	});
}


function getManagers()
{
	$.ajax({
			url:'EmpController',
			type:'GET',
			data:{action:'getManager'},
			dataType:'json',
			success:function(res){
				console.log(res);
				$.each(res,function(index,item){
					var opt=document.createElement('option');
					
					opt.text=item.mname;
					opt.value=item.mid;
					$("#drop").append(opt);
				});	
			},
			error:function(){
				console.log("error");
			}
		});
}


function addEmployee(){
		/*var data = $('#empForm').serialize();*/
/*		console.log(data);

*/		//var val =$("#empForm").serialize();


var name= $("#name").val();
var salary = $("#salary").val();
var mid = $("#drop").val();

		$.ajax({
				url:'EmpController',
				type:'POST',
				data:
				{
					action:'addEmp',
					name:name,
					salary:salary,
					mid:mid
				},
				dataType:'json',
				success:function(res){
					alert(res);
				},
				error:function(){
						console.log("error");
				}
															
	});
	
}