document.getElementById('quiz-form').addEventListener('submit', function(event) {
    event.preventDefault();

    const formData = new FormData(event.target);
    const data = {};
    formData.forEach((value, key) => {
        data[key] = value;
    });

    const csvContent = "data:text/csv;charset=utf-8,"
        + Object.keys(data).join(",") + "\n"
        + Object.values(data).join(",");

    const encodedUri = encodeURI(csvContent);
    const link = document.createElement("a");
    link.setAttribute("href", encodedUri);
    link.setAttribute("download", "form_data.csv");
    document.body.appendChild(link);

    link.click();
    document.body.removeChild(link);
});