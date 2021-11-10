const UPLOAD_URL = "/test";


$("#main-page").click(function () {
    window.location.href = "index.html";
});


$("#submit").click(function () {
    let file = $("#input").prop("files")[0];
//   if (file === undefined || file.name.split(".").pop() !== "zip") {
//       showError("Select .zip file!");
//       return;
//   }
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
        showMessage("Success!", "The article was successfully added.");
    }).fail(function (response) {
        showError(response.responseJSON.message);
    });
});