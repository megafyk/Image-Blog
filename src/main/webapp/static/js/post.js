//Problem: User when clicking on image goes to a dead end
//Solution: Create an overlay with the large image - Lightbox

var $overlay = $('<div id="overlay"></div>');
var $image = $("<img>");
var $caption = $("<p></p>");

//Add overlay
$("body").append($overlay);

//An image to overlay
$overlay.append($image);

//A caption to overlay
$overlay.append($caption);

//Add id 'imageGallery' to the list elements [I made this line by myself!!]
$('li').attr('id', 'imageGallery');

//Capture the click event on a link to an image
$("#imageGallery a").click(function(event){
    event.preventDefault();
    var imageLocation = $(this).attr("href");
    //Update overlay with the image linked in the link
    $image.attr("src", imageLocation);

    //Show the overlay.
    $overlay.show();

    //Get child's title attribute and set caption
    var captionText = $(this).children("img").attr("alt");
    $caption.text(captionText);
});

//When overlay is clicked
$overlay.click(function(){
    //Hide the overlay
    $overlay.hide();
});