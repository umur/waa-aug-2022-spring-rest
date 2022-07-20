window.onload = function () {
    let table = document.getElementById("myTable");

fetch("http://dummy.restapiexample.com/api/v1/employees").then(
  res => {
    res.json().then(
      data => {
        console.log(data.data);
        if (data.data.length > 0) {

          var temp = "";
          data.data.forEach((itemData) => {
            temp += "<tr>";
            temp += "<td>" + itemData.id + "</td>";
            temp += "<td>" + itemData.employee_name + "</td>";
            temp += "<td>" + itemData.employee_salary + "</td></tr>";
          });
          table.innerHTML = temp;
        }
      }
    )
  }
)
