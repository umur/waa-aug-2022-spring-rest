const host = 'http://localhost:8080';
window.onload = function () {
    const urlSearchParams = new URLSearchParams(window.location.search);
    const params = Object.fromEntries(urlSearchParams.entries());
    if (params.id) {
        fetch(`${host}/api/students/${params.id}`)
            .then(response => response.json())
            .then(response => {
                Object.keys(response).forEach(key => {
                    const element = document.getElementById(key);
                    if (element) {
                        element.value = response[key];
                    }
                });
            });
    }
}

function update() {
    const body = validateForm();
    if (body && body.id && body.id !== "") {
        fetch(`${host}/api/students/courses/${body.id}`)
            .then(response => response.json())
            .then(courses => {
                body['coursesToken'] = courses;
                fetch(`${host}/api/students/${body.id}`, {
                    method: 'PUT',
                    headers: {
                        'Content-Type': 'application/json'
                    },
                    body: JSON.stringify(body)
                })
                    .then(response => {
                        location.assign(host);
                    });
            });
    } else {
        body['coursesToken'] = [];
        fetch(`${host}/api/students`, {
            method: 'POST',
            headers: {
              'Content-Type': 'application/json'
            },
            body: JSON.stringify(body)
        })
            .then(response => {
                location.assign(host);
            });
    }
}

function validateForm() {
    const body = {};
    const idElement = document.getElementById('id');
    const fnameElement = document.getElementById('firstName');
    const lnameElement = document.getElementById('lastName');
    const emailElement = document.getElementById('email');
    const majorElement = document.getElementById('major');
    const gpaElement = document.getElementById('gpa');
    if (fnameElement.value === "" || lnameElement.value === ""
    || emailElement.value === "" || majorElement.value === "" || gpaElement.value === "") {
        alert('Fill required fields');
        return null;
    }
    body['id'] = idElement.value;
    body['firstName'] = fnameElement.value;
    body['lastName'] = lnameElement.value;
    body['email'] = emailElement.value;
    body['major'] = majorElement.value;
    body['gpa'] = gpaElement.value;
    return body;
}