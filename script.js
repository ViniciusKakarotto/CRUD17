// Validar as entradas antes de enviar os dados
function validateForm() {
  var name = document.getElementById("name").value;
  var age = document.getElementById("age").value;
  var address = document.getElementById("address").value;
  var email = document.getElementById("email").value;

  if (name == "") {
    alert("O nome é obrigatório");
    return false;
  }

  if (age == "") {
    alert("A idade é obrigatória");
    return false;
  } else if (age < 1) {
    alert("A idade não pode ser zero");
    return false;
  }

  if (address == "") {
    alert("O endereço é obrigatório");
    return false;
  }

  if (email == "") {
    alert("O email é obrigatório");
    return false;
  } else if (!email.includes("@")) {
    alert("Endereço de email inválido");
    return false;
  }

  return true;
}

// Função para mostrar dados
function showData() {
  var peopleList;
  if (localStorage.getItem("peopleList") == null) {
    peopleList = [];
  } else {
    peopleList = JSON.parse(localStorage.getItem("peopleList"));
  }

  var html = "";
  peopleList.forEach(function (element, index) {
    html += "<tr>";
    html += "<td>" + element.name + "</td>";
    html += "<td>" + element.age + "</td>";
    html += "<td>" + element.address + "</td>";
    html += "<td>" + element.email + "</td>";
    html +=
      '<td><button onclick="deleteData(' +
      index +
      ')" class="btn btn-danger">Deletar</button><button onclick="updateData(' +
      index +
      ')" class="btn btn-warning m-2">Editar</button></td>';
    html += "</tr>";
  });

  document.querySelector("#crudTable tbody").innerHTML = html;
}

// Carrega todos os dados quando o documento ou a página é carregada
window.onload = showData;

// Função para adicionar dados
function AddData() {
  if (validateForm()) {
    var name = document.getElementById("name").value;
    var age = document.getElementById("age").value;
    var address = document.getElementById("address").value;
    var email = document.getElementById("email").value;

    var peopleList;
    if (localStorage.getItem("peopleList") == null) {
      peopleList = [];
    } else {
      peopleList = JSON.parse(localStorage.getItem("peopleList"));
    }

    peopleList.push({
      name: name,
      age: age,
      address: address,
      email: email,
    });

    localStorage.setItem("peopleList", JSON.stringify(peopleList));
    showData();

    // Limpar os campos do formulário após adicionar os dados
    document.getElementById("name").value = "";
    document.getElementById("age").value = "";
    document.getElementById("address").value = "";
    document.getElementById("email").value = "";
  }
}

// Função de deletar

function deleteData(index) {
  var peopleList;
  if (localStorage.getItem("peopleList") == null) {
    peopleList = [];
  } else {
    peopleList = JSON.parse(localStorage.getItem("peopleList"));
  }

  peopleList.splice(index, 1);
  localStorage.setItem("peopleList", JSON.stringify(peopleList));
  showData();
}

// Função de editar/atualizar

function updateData(index) {
  document.getElementById("Submit").style.display = "none";
  document.getElementById("Update").style.display = "block";

  var peopleList;
  if (localStorage.getItem("peopleList") == null) {
    peopleList = [];
  } else {
    peopleList = JSON.parse(localStorage.getItem("peopleList"));
  }

  document.getElementById("name").value = peopleList[index].name;
  document.getElementById("age").value = peopleList[index].age;
  document.getElementById("address").value = peopleList[index].address;
  document.getElementById("email").value = peopleList[index].email;

  document.querySelector("#Update").onclick = function () {
    if (validateForm()) {
      peopleList[index].name = document.getElementById("name").value;
      peopleList[index].age = document.getElementById("age").value;
      peopleList[index].address = document.getElementById("address").value;
      peopleList[index].email = document.getElementById("email").value;

      localStorage.setItem("peopleList", JSON.stringify(peopleList));

      showData();

      document.getElementById("name").value = "";
      document.getElementById("age").value = "";
      document.getElementById("address").value = "";
      document.getElementById("email").value = "";

      document.getElementById("Submit").style.display = "block";
      document.getElementById("Update").style.display = "none";
    }
  };
}
