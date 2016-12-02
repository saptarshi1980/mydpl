
<!DOCTYPE html>
<html>
<head>
    <title>The Durgapur Projects Limited</title>
    <link href="js-image-slider.css" rel="stylesheet" type="text/css" />
    <script src="js-image-slider.js" type="text/javascript"></script>
    <link href="generic.css" rel="stylesheet" type="text/css" />
    <link rel="stylesheet" href="styles.css">
   	<script src="http://code.jquery.com/jquery-latest.min.js" type="text/javascript"></script>
   	<script src="script.js"></script>
   	<script
    src="https://maps.googleapis.com/maps/api/js?v=3.exp&sensor=false">
    </script>
 
 <script>
var map;
function initialize() {
    var myLatlng = new google.maps.LatLng(23.50517, 87.29157);
    var myOptions = {
        zoom: 12,
        center: myLatlng,
        mapTypeId: google.maps.MapTypeId.ROADMAP
    }
    map = new google.maps.Map(document.getElementById("map_canvas"), myOptions);
    TestMarker();
}

// Function for adding a marker to the page.
function addMarker(location) {
    marker = new google.maps.Marker({
        position: location,
        map: map
    });
}

// Testing the addMarker function
function TestMarker() {
       CentralPark = new google.maps.LatLng(23.50517, 87.29157);
       addMarker(CentralPark);
}
google.maps.event.addDomListener(window, 'load', initialize);
</script>
   
</head>
<body>
    
    <div id="logo" align="center">
    <table>
    <tr>
    <td><img src="imgs/DPL_Logo3.jpg" /></td>
    
    
    <td align="right">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img src="imgs/email.jpg" /></td><td><a href ="https://login.secureserver.net/index.php?app=wbe&domain=webmail.dpl.net.in" target ="_blank">Corporate&nbsp;Mail</a></td>
    <td>&nbsp;&nbsp;<a href ="#" >Downloads</a></td><td>&nbsp;&nbsp;<a href ="#" >Sitemap</a></td>
    </tr>
    </table>
    
 </div><br>
  <div id="menumain" align="center">
  
  <div id='cssmenu'align="right">
<ul>
   <li><a href='index.jsp'><span>Home</span></a></li>
   <li class='active has-sub'><a href='#'><span>About us</span></a>
      <ul>
         <li class='last'><a href="aboutDPL"><span>About DPL</span></a>
         <!-- <li class='has-sub'><a href='#'><span>About DPL</span></a> -->
            <!-- <ul>
               <li><a href='#'><span>Sub Product</span></a></li>
               <li class='last'><a href='#'><span>Sub Product</span></a></li>
            </ul> -->
         </li>
         <li class='last'><a href='#'><span>Mission</span></a>
         <!-- <li class='has-sub'><a href='#'><span>Mission</span></a> -->
            <!-- <ul>
               <li><a href='#'><span>Sub Product</span></a></li>
               <li class='last'><a href='#'><span>Sub Product</span></a></li>
            </ul> -->
         </li>
         <li class='last'><a href='#'><span>Vision</span></a></li>
         <li class='last'><a href='#'><span>Chairman Desk</span></a></li>
         <li class='last'><a href='#'><span>MD Desk</span></a></li>
         <li class='last'><a href='#'><span>Contact Us</span></a></li>
      </ul>
   </li>
   <li class='active has-sub'><a href='#'><span>Business Unit</span></a>
   
  	  <ul>
         <li class='last'><a href='#'><span>Power Plant</span></a></li>
         <li class='last'><a href='#'><span>Coke Oven</span></a></li>
         <li class='last'><a href='#'><span>Water Works</span></a></li>
         <li class='last'><a href="Report1.jsp"><span>Reports</span></a></li>
      </ul>
   
   </li>
   <li class='active has-sub'><a href='#'><span>HRD</span></a>
   
      <ul>
         
         <li class='last'><a href='#'><span>HR Policy & Orders </span></a></li>
      </ul>
   </li>   
   
   <li class='active has-sub'><a href='#'><span>Career</span></a>
   
      <ul>
         <li class='last'><a href="Jobs1.jsp"><span>Jobs at DPL</span></a></li>
         <li class='last'><a href="CareerResult1.jsp"><span>Results</span></a></li>
        
      </ul>
   </li>  
   <li class='last'><a href='#'><span>Consumers</span></a>
   
     <ul>
         <li class='last'><a href='#'><span>Electricity Bill</span></a></li>
         <li class='last'><a href='#'><span>Pay Bill Online</span></a></li>
         <li class='last'><a href='#'><span>Consumer Information</span></a></li>
         <li class='last'><a href='#'><span>Grievances</span></a></li>
      </ul>
   
   </li>
   <li class='last'><a href='#'><span>CSR</span></a>
   
    <ul>
         <li class='last'><a href='#'><span>Corporate Social Responsibility</span></a></li>
         <li class='last'><a href='#'><span>Water Conservation</span></a></li>
         <li class='last'><a href='#'><span>Environment Policy</span></a></li>
    </ul>
   
   </li>
   <li class='last'><a href="page5.jsp"><span>Tariff</span></a></li>
   <li class='last'><a href='#'><span>Photo Gallery</span></a></li>
   <li class='last'><a href='#'><span>RTI</span></a>
   
      <ul>
         <li class='last'><a href="RTI1.jsp"><span>About RTI</span></a></li>
         <li class='last'><a href='#'><span>Public Information Officer</span></a></li>
         <li class='last'><a href='#'><span>Appellate Authority</span></a></li>
         <li class='last'><a href="AnnualReport1.jsp"><span>Annual Report</span></a></li>
         <li class='last'><a href="Policy1.jsp"><span>Record Retention Policy</span></a></li>
      </ul>
   
   </li>
   <li class='last'><a href="page3.jsp"><span>Tenders</span></a></li>
   <li class='last'><a href='#'><span>Feedback</span></a></li>
   <li class='last'><a href="page7.jsp"><span>RecentSolution</span></a></li>
</ul>
</div>
  
  </div>
   <br>
  
    <div id="sliderFrame" >
        <table>
        <tr><td>
        <div id="slider">
            <img src="imgs/1.jpg" alt="Eco Friendly Power Generation" />
            <img src="imgs/2.jpg" alt="An Industry for Indusrty" />
            <img src="imgs/3.jpg" alt="Eco Friendly Power Generation" />
            <img src="imgs/4.jpg" alt="Eco Friendly Coke Generation" />
            <img src="imgs/5.jpg" alt="Water Treatment" />
        </div>
        <div id="htmlcaption" style="display: none;">
            <em>HTML</em> caption. Link to <a href="http://www.google.com/">Google</a>.
        </div>
        </td>
        </tr>
        
        <tr><td align="justify"><font size="2" color="black"> The Durgapur Projects Ltd (DPL), a five-decade-old multi-utility growth propeller, is one of the major planks of expansion and prosperity of West Bengal's industrial belt Durgapur.
        The Durgapur Projects Ltd was incorporated on 6th September, 1961 and consists of Coke Oven Batteries, Bye-products Plant, Gas Grid Project, Thermal Power Plant and Water Works.It is under the administrative control of the Department of Power and Non-conventional Energy Sources, Government of West Bengal. 
        The Durgapur Projects Ltd  is  the first undertaking of  the  State Government  which has been engaged in  development of infrastructure  for  Industries and  was given the stature of an "Industry for Industries". Its main objective was to promote development of various large, medium and small scale industries in and around Durgapur and also at other places within the State.</font> 	
        </td>
        </tr> 
        </table>
        <table>
        <tr><td>
          <div id="map_canvas" style="height:200px; width:600px" align="justify"></div>
          </td>
          </tr>
        </table>
    </div>
    
                
    


</body>
</html>
