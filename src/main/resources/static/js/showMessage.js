function showMessage(title, message){
    $("#modal-title").text(title)
    $("#modal-text").text(message);
}

function showError(message) {
    showMessage("Error!", message)
}