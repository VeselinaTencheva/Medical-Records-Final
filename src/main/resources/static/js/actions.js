// function showMSForm() {
//     const showMSForm = document.getElementById('showMSForm');
//     if (document.getElementById('isMS').checked) {
//         showMSForm.style.display = 'none';
//     } else {
//         showMSForm.style.display = 'block';
//     }
// }
//
// function showGPForm() {
//     const showGPForm = document.getElementById('showGPForm');
//     if (!document.getElementById('isGP').checked) {
//         showGPForm.style.display = 'none';
//     } else {
//         showGPForm.style.display = 'block';
//     }
// }

function showGPForm() {
    var checkBox = document.getElementById("isGP");
    var form = document.getElementById("showGPForm");
    if (checkBox.checked == true){
        form.style.display = "flex";
    } else {
        form.style.display = "none";
    }
}

function showMSForm() {
    var checkBox = document.getElementById("isMS");
    var form = document.getElementById("showMSForm");
    if (checkBox.checked == true){
        form.style.display = "block";
    } else {
        form.style.display = "none";
    }
}

