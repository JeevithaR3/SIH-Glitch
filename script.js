// Get the dropdown button and content
var dropdown = document.getElementsByClassName("dropdown")[0];
var dropdownContent = document.getElementsByClassName("dropdown-content")[0];

// Add an event listener to the dropdown button
dropdown.addEventListener("click", function() {
  // Toggle the dropdown content
  dropdownContent.style.display = (dropdownContent.style.display === "block") ? "none" : "block";
});