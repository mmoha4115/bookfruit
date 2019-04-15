$("#search").submit(
    function(e) {
      e.preventDefault();
      var isbn = $('#ISBN').val();
      var isbn_without_hyphens = isbn.replace(/-/g, "");
      var googleAPI = "https://www.googleapis.com/books/v1/volumes?q=" + isbn_without_hyphens;
      $.getJSON(googleAPI, function(response) {
          console.log(response);
        if (typeof response.items === "undefined") {
          alert("No books match that ISBN.")
        } else {
          $("#title").html(response.items[0].volumeInfo.title);
          $("#author").html(response.items[0].volumeInfo.authors[0]);
          $("#isbn13").html(response.items[0].volumeInfo.industryIdentifiers[1].identifier);
          $("#publishedDate").html(response.items[0].volumeInfo.publishedDate);
          $("#thumbnail").html(response.items[0].volumeInfo.imageLinks.smallThumbnail);
          $("#cover").attr("src",response.items[0].volumeInfo.imageLinks.smallThumbnail);
          $( "#bookselection" ).append( "<input type='submit' value='SELECT' >" );
        }
      });
    }
  );