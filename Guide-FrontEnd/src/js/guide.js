loadAllGuides();

function loadAllGuides() {

    function loadHotelData() {
        $.ajax({
            url: 'http://localhost:8060/Mapping/api/guide', // Replace with your actual backend URL
            method: 'GET',
            dataType: 'json',
            success: function (data) {
                if (data.code === '200') {
                    var guides = data.data;
                    var guidelList = $('#card-container');

                    // Iterate through the hotel data and create card elements
                    for (var i = 0; i < guides.length; i++) {
                        var guide = guides[i];
                        var card = `
                                      <div class="col-12 col-md-6 col-lg-3 card-wrapper mt-4">
                                        <div class="card">
                                          <img class="card-img-top" src="images/1.jpg" alt="...">
                                          <div class="card-body">
                                            <!--  Customize this section  -->
                                             <div class="card-title" title=""><u><h5>`+guide.guide_name+`</h5></u></div>
                                              <div class="card-title" title="">`+guide.address+`</div>
                                              <div class="card-title" title="">`+guide.age+`</div>
                                              <div class="card-title" title="">`+vehicle.gender+`</div>
                                              <div class="card-title" title="">`+vehicle.experience+`</div>
                                              <div class="card-title" title="">`+vehicle.day_value+`</div>
                                              <div class="card-title" title="">`+vehicle.vehicle_type+`</div>
                                              <div class="card-title" title="">`+vehicle.guider_contact+`</div>

                        
                                            <!--  End  -->
                                          </div>
                                        </div>
                                      </div>
                        `;



                        guidelList.append(card);

                        $("#card-container .col-12:last-child div img").attr('src', `data:image/png;base64,`+guide.guide_img+``);

                    }
                } else {
                    // Handle the error case here
                    console.log('Error: ' + data.message);
                }
            },
            error: function (error) {
                // Handle the error case here
                console.log('Error: ' + error);
            }
        });
    }

    // Call the function to load hotel data
    loadHotelData();



}

