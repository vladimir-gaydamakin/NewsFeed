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
        $("#text").text("Success!!! Article added");
    }).fail(function (response) {
        $("#text").text(response.responseJSON.message);
    });
});

$("#main-page").click(function () {
    window.location.href = "index.html";
});