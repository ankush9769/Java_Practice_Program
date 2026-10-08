<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    
   
 <link rel="stylesheet" href="https://cdn.datatables.net/2.3.4/css/dataTables.dataTables.min.css">
   
    <script src="https://cdn.datatables.net/2.3.4/js/dataTables.min.js"></script>
   
    <script src="emps.js"></script>  
   
</head>
<body>
<input type="button" class="btn btn-primary" id="modalBtn" value="ADD">

<table class="table" id="emptable">
  <thead>
    <tr>
      <th scope="col">ID</th>
      <th scope="col">Name</th>
      <th scope="col">Salary</th>
      <th scope="col">Reporting Manager</th>
    </tr>
  </thead>
  <tbody id="empdata">
    
  </tbody>
</table>

<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
<div class="modal-body">
    <form method="post" id="empForm">
        <div class="mb-3">
            <label for="name" class="form-label">
                Name
            </label>
            <input type="text"
                   class="form-control"
                   name="name"
                   id="name"
                   placeholder="Enter employee name"
                   required>
        </div>

        <div class="mb-3">
            <label for="salary" class="form-label">
                Salary
            </label>
            <input type="number"
                   class="form-control"
                   name="salary" 
                   id="salary"
                   placeholder="Enter salary"
                   required>
        </div>

        <div class="mb-3">
            <label for="drop" class="form-label">
                Reporting Manager
            </label>
            <select class="form-select"
            name="mid"
                    id="drop"
                    
                    required >
            </select>
        </div>


    </form>

</div>      </div>
<div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="submit" class="btn btn-primary" id="addEmp">Save changes</button>
      </div>
      
    </div>
  </div>
</div>









</body>
</html>