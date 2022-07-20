let allStudents = [];
let allCourses = [];

const emptyValues = () => {
    allProducts = [];
    currentOrder = null;
}

const getAuthToken = () => {
    return sessionStorage.getItem('token');
}

const getProduct = (productId) => {
    return allProducts.find((product) => product.id == productId);
}

const getProductFromOrder = (productId) => {
    if (currentOrder) {
        return currentOrder.cartProducts.find((crtProduct) => crtProduct.product.id === productId);
    }
    return null;
}

const getNewItemCount = (productId, count) => {
    const currentCartItem = getProductFromOrder(productId);
    let newItemCount = 0;
    if (currentCartItem) {
        const { itemCount } = currentCartItem;
        newItemCount = itemCount + count;
    } else {
        newItemCount = 1;
    }
    return newItemCount;
}

window.onload = function () {

    load();

}

const load = () => {
    loadStudents();
    loadAllCourses();
}



const loadAllCourses = async function () {
    const userId = sessionStorage.getItem('userId');

    let results = await fetch('http://localhost:8080/courses');

    const courses  = await results.json();

    if (courses) {
        allCourses = courses;
    }

    console.log("All courses", allCourses);
    updateDomWithCourses(allCourses);
}

const loadStudents = async function () {

    let results = await fetch('http://localhost:8080/students');


    const studentsResults =  await results.json();

    if (studentsResults && studentsResults.length) {

        allStudents = studentsResults;
    }
    updateDomWithStudents(allStudents);


}

const addNewCourse = async () => {

    let results = await fetch('http://localhost:8080/courses/', {
        method: 'POST',
       
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify({
            id: 5,
            name: 'MWA',
            code: 'CSMWA'
        })
    });

    if (results.status === 200 || results.status === 201) {
        load();
    }
}


const updateDomWithCourses = function (courses) {

    if (courses && courses.length) {
        let tableData = '<th>Id</th><th>Name</th><th>Code</th>';
        courses.forEach((course) => {
            const { id, name, code } = course;
            console.log("The values", id, name, code);
            tableData += `<tr id="cart-item-${id}"><td>${id}</td><td>${name}</td><td>${code}</td></tr>`;
        });
       
        document.getElementById("items-table").innerHTML = tableData;
    } 

}


const updateDomWithStudents = function (students) {
    if (students && students.length) {
        let tableData = '<th>Id</th><th>First Name</th><th>LastName</th><th>Email</th><th>Major</th>'
        students.forEach((student) => {
            const { id, firstName, lastName, major, email } = student;
            tableData += `<tr><td>${id}</td><td>${firstName}</td><td>${lastName}</td><td>${email}</td><td>${major}</td></tr>`
        });
       
        document.getElementById("products-table").innerHTML = tableData;
    } else {
        document.getElementById("product-list").style.display = 'none';
    }

}
