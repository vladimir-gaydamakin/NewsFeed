const UPLOAD_URL = "/upload";

$("#submit").click(function () {
    let file = $("#input").prop("files")[0];
    let formData = new FormData();
    formData.append("file", file);
    $.ajax({
        url: `${UPLOAD_URL}`,
        type: "POST",
        data: formData,
        cache: false,
        contentType: false,
        processData: false,
        origin: "*"
    }).done(function () {
        $("#modal-text").text("The article was successfully added.");
    }).fail(function (response) {
        $("#modal-text").text(response.responseJSON.message);
    });
});

$("#main-page").click(function () {
    window.location.href = "index.html";
});