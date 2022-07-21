let URL = "http://localhost:8082";

async function showStudents() {
  let headers = new Headers();

  headers.append('Content-Type', 'application/json');
  headers.append('Accept', 'application/json');

  headers.append('Access-Control-Allow-Origin', 'http://localhost:8082');
  headers.append('Access-Control-Allow-Credentials', 'true');

  headers.append('GET', 'POST', 'OPTIONS');

  try {
    await fetch(`${URL}/students`, {
        method: "GET",
        headers: headers,
        credentials: "same-origin",
      })
      .then(response => response.json())
      .then(jsonData => {
        let studentsList = document.getElementById("show");
        for (let student of jsonData) {
          let aList = document.createElement("li");
          aList.className = "list-group-item";
          aList.innerHTML = `<b>Id:</b> ${student.id} <b>Name:</b> ${student.firstName} ${student.lastName}</b> <b>Email:</b> ${student.email} <b>Gpa:</b> ${student.gpa} <b>Major:</b> ${student.major}`;
          studentsList.appendChild(aList);
        }
      })
  } catch (err) {
    console.error(err);
  }
}

showStudents();