let studentMap = new Map();
async function loadTable() {
    let objects;
    objects = await (
        await fetch(`http://127.0.0.1:8080/students/`, {
            method: "GET",
            headers: {
                "Content-Type": "application/json",
            },
            credentials: "same-origin",
        })
    ).json();

    var trHTML = '';
    for (let object of objects) {
        trHTML += '<tr>';
        trHTML += '<td>'+object['id'] + '</td>';
        trHTML += '<td>'+object['firstName']+'</td>';
        trHTML += '<td>'+object['lastName']+'</td>';
        trHTML += '<td>'+object['email']+'</td>';
        trHTML += '<td>'+object['major']+'</td>';
        trHTML += '<td>'+object['gpa']+'</td>';
        trHTML += '<td><button type="button" class="btn btn-outline-secondary" onclick="showStudentUpdateBox('+object['id']+')">Edit</button>';
        trHTML += '<button type="button" class="btn btn-outline-danger" onclick="studentDelete('+object['id']+')">Del</button></td>';
        trHTML += "</tr>";
        studentMap.set(object['id'], object);
    }

    document.getElementById("mytable").innerHTML = trHTML;

}

loadTable();


function showStudentCreateBox() {
    Swal.fire({
        title: 'Create Student',
        html:
            '<input id="id" type="hidden">' +
            '<input id="firstName" class="swal2-input" placeholder="FirstName">' +
            '<input id="lastName" class="swal2-input" placeholder="LastName">' +
            '<input id="email" class="swal2-input" placeholder="Email">' +
            '<input id="major" class="swal2-input" placeholder="Major">'+
            '<input id="gpa" class="swal2-input" placeholder="Gpa">',
        focusConfirm: false,
        preConfirm: () => {
            studentCreate();
        }
    })
}

async function studentCreate() {
    let firstName = document.getElementById("firstName").value;
    let lastName = document.getElementById("lastName").value;
    let email = document.getElementById("email").value;
    let major = document.getElementById("major").value;
    let gpa = document.getElementById("gpa").value;

    let bodyJson = {
        "firstName": firstName, "lastName": lastName, "email": email, "major": major, "gpa": gpa,
    }

    const rawResponse = await fetch(`http://127.0.0.1:8080/students/`, {
        method: 'POST',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(bodyJson)
    });
    if(rawResponse.ok){
        loadTable();
    }

}



function showStudentUpdateBox(id) {
    var student = studentMap.get(id);
    console.log(student);
    Swal.fire({
        title: 'Edit Student',
        html:
            '<input id="id" type="hidden" value="' + student['id'] + '">' +
            '<input id="firstName" class="swal2-input" placeholder="FirstName" value="' + student['firstName'] + '">' +
            '<input id="lastName" class="swal2-input" placeholder="LastName" value="' + student['lastName'] + '">' +
            '<input id="email" class="swal2-input" placeholder="Email" value="' + student['email'] + '">' +
            '<input id="major" class="swal2-input" placeholder="Major" value="' + student['major'] + '">'+
            '<input id="gpa" class="swal2-input" placeholder="Gpa" value="' + student['gpa'] + '">',
        focusConfirm: false,
        preConfirm: () => {
            studentUpdate();
        }
    })
}



async function studentUpdate() {
    let id = document.getElementById("id").value;
    let firstName = document.getElementById("firstName").value;
    let lastName = document.getElementById("lastName").value;
    let email = document.getElementById("email").value;
    let major = document.getElementById("major").value;
    let gpa = document.getElementById("gpa").value;

    let bodyJson = {
        "id": id,  "firstName": firstName, "lastName": lastName, "email": email, "major": major, "gpa": gpa,
    }

    const rawResponse = await fetch(`http://127.0.0.1:8080/students/${id}`, {
        method: 'PUT',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(bodyJson)
    });
    if(rawResponse.ok){
        loadTable();
    }
}

async function studentDelete(id) {
    const rawResponse = await fetch(`http://127.0.0.1:8080/students/` + id, {
        method: 'DELETE',
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        }
    });
    if(rawResponse.ok){
        loadTable();
    }
}
