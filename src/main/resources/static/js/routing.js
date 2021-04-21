// возможно потом мне будет стыдно за код ниже :p
// но пока есть как есть.

let id_employee = document.getElementById("id_employee");
let id_cassa = document.getElementById("id_cassa");
let id_city = document.getElementById("id_city");

id_employee.onclick = function () {
    window.location.href = '/employees';
}

id_cassa.onclick = function () {
    window.location.href = '/cassa';
}

id_city.onclick = function () {
    window.location.href = '/cities';
}

