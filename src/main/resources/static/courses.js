const host = 'http://localhost:8080';
window.onload = function () {
    const urlSearchParams = new URLSearchParams(window.location.search);
    const params = Object.fromEntries(urlSearchParams.entries());
    if (params.id) {
        fetch(`${host}/api/courses/${params.id}`)
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
        fetch(`${host}/api/courses/${body.id}`, {
            method: 'PUT',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(body)
        })
            .then(response => {
                location.assign(host);
            });
    } else {
        body['coursesToken'] = [];
        fetch(`${host}/api/courses`, {
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
    const nameElement = document.getElementById('name');
    const codeElement = document.getElementById('code');
    if (nameElement.value === "" || nameElement.value === "") {
        alert('Fill required fields');
        return null;
    }
    body['id'] = idElement.value;
    body['name'] = nameElement.value;
    body['code'] = codeElement.value;
    return body;
}