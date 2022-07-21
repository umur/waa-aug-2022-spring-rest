window.onload = function () {
  const url = "http://localhost:8080/api/v1"
  loadData();

  document.getElementById("btnFormUpdate").onclick = (e) => {
    const id = document.getElementById("txt-courseId").value;
    fetch(`${url}/courses/${id}`, {
      method: "PUT",
      body: JSON.stringify({
        id: id,
        name: document.getElementById("txt-name").value,
        code: document.getElementById("txt-code").value,
      }),
      headers: {
        "Content-Type": "application/json; charset=UTF-8",
      },
    })
      .then((res) => {
        document.getElementById("courseForm").reset();
        document.getElementById('btnFormUpdate').style.display = "none";
        document.getElementById("btnFormAdd").style.display = "inline";

        loadData();
      });
  };

  document.getElementById("courseForm").addEventListener("submit", function (e) {
    e.preventDefault();
    fetch(`${url}/courses`, {
      method: "POST",
      body: JSON.stringify({
        id: document.getElementById("txt-courseId").value,
        name: document.getElementById("txt-name").value,
        code: document.getElementById("txt-code").value,
      }),
      headers: {
        "Content-Type": "application/json; charset=UTF-8",
      },
    })
      .then((res) => {
        document.getElementById("courseForm").reset();
        loadData();
      });
  });

  document.getElementById("getAll").addEventListener("click", loadData);

  document.getElementById("addNew").addEventListener("click", function () {
    document.getElementById("courseForm").reset();
    document.getElementById("txt-courseId").value = 0;
    document.getElementById("btnFormUpdate").style.display = "none";
    document.getElementById("btnFormAdd").style.display = "inline";
  });

  function loadData(event) {
    fetch(`${url}/courses`)
      .then((res) => res.json())
      .then((res) => {
        showDataInTable(res);
        refreshEvent();
      });
  }

  const showDataInTable = function (data) {
    let htmlString = "";
    data.forEach((x) => {
      htmlString += " <tr>";
      htmlString += `<td>${x.id}</td>`;
      htmlString += `<td>${x.name}</td>`;
      htmlString += `<td>${x.code}</td>`;
      htmlString += `<td><button class="updateButton" name="updateButton" tag=${x.id}>update</button> |
      <button class="deleteButton" name="deleteButton" tag=${x.id}>Delete</button></td>`;
      htmlString += "</tr>";
    });

    document.getElementById("tableBody").innerHTML = htmlString;
  };

  function refreshEvent() {
    let btns = document.getElementsByClassName("updateButton");
    Array.prototype.forEach.call(btns, function addClickListener(btn) {
      btn.addEventListener("click", function (event) {
        getById(this.getAttribute("tag"));
      });
    });

    let removeBtns = document.getElementsByClassName("deleteButton");
    Array.prototype.forEach.call(removeBtns, function addClickListener(btn) {
      btn.addEventListener("click", function (event) {
        deleteById(this.getAttribute("tag"));
      });
    });
  }

  const getById = function (courseId) {
    fetch(`${url}/courses/${courseId}`)
      .then((res) => res.json())
      .then((res) => {
        document.getElementById("txt-courseId").value = res.id;
        document.getElementById("txt-name").value = res.name;
        document.getElementById("txt-code").value = res.code;
        document.getElementById("btnFormUpdate").style.display = "inline";
        document.getElementById("btnFormAdd").style.display = "none";
      });
  };

  const deleteById = function (id) {
    fetch(`${url}/courses/${id}`, {
      method: "DELETE",
      headers: {
        "Content-Type": "application/json; charset=UTF-8",
      },
    })
      .then((res) => {
        alert("Record has been successfully delete.");
        loadData();
        refreshEvent();
      });
  };
};
