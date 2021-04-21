import org.testng.annotations.Test;


public class FeatureTest {

    @Test
    public void testcase_1(){
        String testData = "AM/FM Stereo|" +
                "Audio system feature, 6-speaker system|" +
                "Auxiliary Audio Input|" +
                "MP3 Player|" +
                "Noise control system, active noise cancellation|" +
                "Satellite Radio|Smart Device Integration|" +
                "Door handles, body-color with chrome strip|" +
                "Glass, acoustic, laminated windshield|Glass, laminated front doors|" +
                "Headlamp control, automatic on and off|Headlamps, automatic delay|" +
                "headlights, halogen composite with automatic exterior lamp control|" +
                "License plate front mounting package|" +
                "Memory settings, includes presets for driver seat adjuster and outside rearview mirror|" +
                "Mirror, inside rearview auto-dimming|" +
                "Mirrors, outside heated power-adjustable, body-color, manual-folding with turn signal indicators and driver side auto-dimming|" +
                "Tire Pressure Monitoring System|Tire, spare T145/70R17 SL blackwall|" +
                "Tires, P225/60R18 all-season blackwall|" +
                "Wheel, 17\" (43.2 cm) steel spare|" +
                "Wheels, 18\" (45.7 cm) 10-spoke polished aluminum|" +
                "Air conditioning, tri-zone automatic climate control with individual climate settings for driver, front passenger and rear seat";
        FeatureParser.parseFeature(testData);
    }

    @Test
    public void testcase_2(){
        String testData = "6 Speakers|" +
                "AM/FM radio: SiriusXM|" +
                "CD player|MP3 decoder|" +
                "Radio: Entune Audio Display AM/FM/HD w/CD Player|" +
                "Air Conditioning|Power steering|" +
                "Power windows|" +
                "Remote keyless entry|Speed-sensing steering|" +
                "Traction control|4-Wheel Disc Brakes|" +
                "ABS brakes|" +
                "Dual front impact airbags|Dual front side impact airbags|" +
                "Front anti-roll bar|Front wheel independent suspension|" +
                "Knee airbag|Low tire pressure warning|Occupant sensing airbag|" +
                "Overhead airbag|Brake assist|Electronic Stability Control|" +
                "Exterior Parking Camera Rear|Front fog lights|Panic alarm|" +
                "Speed control|Front Fog & Daytime Running Lights|Heated door mirrors|" +
                "Power door mirrors|Rear step bumper|Driver door bin|Driver vanity mirror|" +
                "Front reading lights|Illuminated entry|Illuminated Entry System|" +
                "Outside temperature display|Overhead console|Passenger vanity mirror|" +
                "Rear reading lights|Tachometer|Tilt steering wheel|Voltmeter|" +
                "3-Passenger Front Bench Seat|Fabric Seat Trim|Rear Under-Seat Storage Compartment|" +
                "Split folding rear seat|Front Center Armrest w/Storage|Passenger door bin|…";
        FeatureParser.parseFeature(testData);
    }

    @Test
    public void testcase_3(){
        String data = "1 LCD Monitor In The Front|" +
                "Integrated Roof Antenna|" +
                "Radio w/Seek-Scan, MP3 Player, Clock, Speed Compensated Volume Control, Aux Audio Input Jack, Steering Wheel Controls and External Memory Control|" +
                "Radio: AM/FM/CD/RDS/AUX NissanConnect w/Navigation -inc: mobile apps and services, Bose audio w/9 speakers, 7\" color touch-screen display, USB connection port for iPod interface and other compatible devices, Bluetooth hand-free phone system, XM Satellite radio, Nissan voice recognition for navigation and audio, SiriusXMTraffic, SiriusXM Travel Link (Weather, Fuel prices, Movie listings, Stock info and Sports Scores) and Siri Eyes Free|" +
                "Streaming Audio|" +
                "Black Bodyside Cladding and Black Wheel Well Trim|" +
                "Black Grille w/Chrome Surround|" +
                "Body-Colored Front Bumper|" +
                "Body-Colored Power Heated Side Mirrors w/Manual Folding and Turn Signal Indicator|" +
                "Body-Colored Rear Bumper w/Black Rub Strip/Fascia Accent|" +
                "Chrome Door Handles|Chrome Side Windows Trim|" +
                "Clearcoat Paint|" +
                "Compact Spare Tire Mounted Inside Under Cargo|" +
                "Driver And Passenge…";
        FeatureParser.parseFeature(data);
    }

    @Test
    public void testcase4() {
        String data = "Navigation system|"+
                "Lane departure|"+
                "Leather upholstery|"+
                "Automatic temperature control|"+
                "Emergency communication system|"+
                "Power moonroof|"+
                "Wireless phone connectivity|"+
                "Parking sensors|";
        FeatureParser.parseFeature(data);
    }

    //plural singular
    @Test
    public void testcase5() {
        String data = "Power door mirrors|" +
                "Knee airbag|" +
                "3-Passenger Front Bench Seat|" +
                "6 Speaker|" +
                "Heated door mirrors|" +
                "Steering Wheel Controls and External Memory Control";
        FeatureParser.parseFeature(data);
    }



    @Test
    public void TestApiFeatureData(){
        String data =  "Towing Equipment -inc: Trailer Sway Control|"+
                "3.45 Rear Axle Ratio|"+
                "Heavy Duty Suspension w/Gas Shocks|"+
                "GVWR: 5,500 lbs|"+
                "50 State Emissions|"+
                "Manual Transfer Case|"+
                "Part-Time Four-Wheel Drive|"+
                "650CCA Maintenance-Free Battery w/Run Down Protection|"+
                "220 Amp Alternator|"+
                "Aux Battery|"+
                "Stop-Start Dual Battery System|"+
                "3 Skid Plates|"+
                "1237# Maximum Payload|"+
                "Front And Rear Anti-Roll Bars|"+
                "Electro-Hydraulic Power Assist Steering|"+
                "Single Stainless Steel Exhaust|"+
                "21.5 Gal. Fuel Tank|"+
                "Auto Locking Hubs|"+
                "Leading Link Front Suspension w/Coil Springs|"+
                "Trailing Arm Rear Suspension w/Coil Springs|"+
                "4-Wheel Disc Brakes w/4-Wheel ABS, Front Vented Discs, Brake Assist and Hill Hold Control|"+
                "Brake Actuated Limited Slip Differential|"+
                "Wheels: 18\" x 7.5\" Gloss Black Aluminum|"+
                "Tires: 255/70R18 All Terrain|"+
                "Full-Size Spare Tire Mounted Outside Rear|"+
                "Clearcoat Paint|"+
                "Black Rear Bumper w/1 Tow Hook|"+
                "Front Bumper w/2 Tow Hooks|"+
                "Black Side Windows Trim|"+
                "Black Door Handles|"+
                "Black Wheel Well Trim and Body-Colored Fender Flares|"+
                "Black Power Heated Side Mirrors w/Manual Folding|"+
                "Deep Tinted Glass|"+
                "Variable Intermittent Wipers|"+
                "Galvanized Steel/Aluminum/Magnesium Panels|"+
                "Convertible w/Fixed Roll-Over Protection|"+
                "Side Steps|"+
                "Conventional Rear Cargo Access|"+
                "Tailgate/Rear Door Lock Included w/Power Door Locks|"+
                "Auto On/Off Aero-Composite Halogen Daytime Running Headlamps w/Delay-Off|"+
                "Front Fog Lamps|"+
                "Non-Lock Fuel Cap w/o Discriminator|"+
                "Radio: Uconnect 4 w/7\" Display|"+
                "Radio w/Seek-Scan, Clock, Speed Compensated Volume Control, Aux Audio Input Jack, Steering Wheel Controls, Voice Activation, Radio Data System and Uconnect External Memory Control|"+
                "8 Speakers|"+
                "Streaming Audio|"+
                "Fixed Antenna|"+
                "GPS Antenna Input|"+
                "Apple CarPlay|"+
                "2 LCD Monitors In The Front|"+
                "Front Seats w/Manual Driver Lumbar|"+
                "6-Way Driver Seat -inc: Manual Recline, Height Adjustment, Fore/Aft Movement and Manual Lumbar Support|"+
                "4-Way Passenger Seat -inc: Manual Recline and Fore/Aft Movement|"+
                "60-40 Folding Split-Bench Front Facing Fold Forward Seatback Rear Seat|"+
                "Manual Tilt/Telescoping Steering Column|"+
                "Power Rear Windows|"+
                "Leather Steering Wheel|"+
                "Illuminated Front Cupholder|"+
                "Illuminated Rear Cupholder|"+
                "2 12V DC Power Outlets|"+
                "Compass|"+
                "Proximity Key For Push Button Start Only|"+
                "Remote Keyless Entry w/Integrated Key Transmitter, Illuminated Entry and Panic Button|"+
                "Garage Door Transmitter|"+
                "Cruise Control w/Steering Wheel Controls|"+
                "Voice Activated Dual Zone Front Automatic Air Conditioning|"+
                "HVAC -inc: Console Ducts|"+
                "Locking Glove Box|"+
                "Interior Trim -inc: Metal-Look Door Panel Insert and Metal-Look Interior Accents|"+
                "MOPAR Hardtop Headliner|"+
                "Day-Night Rearview Mirror|"+
                "Driver And Passenger Visor Vanity Mirrors w/Driver And Passenger Illumination|"+
                "Full Floor Console w/Locking Storage, 2 12V DC Power Outlets and 1 120V AC Power Outlet|"+
                "Front And Rear Map Lights|"+
                "Fade-To-Off Interior Lighting|"+
                "Carpet Floor Trim, Carpet And Rubber Mat|"+
                "Full Carpet Floor Covering -inc: Carpet Front And Rear Floor Mats|"+
                "Locking Cargo Area Concealed Storage|"+
                "Cargo Space Lights|"+
                "110 MPH Vehicle Max Speed Calibration|"+
                "Integrated Voice Command w/Bluetooth|"+
                "Google Android Auto|"+
                "Instrument Panel Bin, Dashboard Storage, Driver / Passenger And Rear Door Bins|"+
                "Power 1st Row Windows w/Driver And Passenger 1-Touch Down|"+
                "Delayed Accessory Power|"+
                "Power Door Locks w/Autolock Feature|"+
                "Systems Monitor|"+
                "Redundant Digital Speedometer|"+
                "Trip Computer|"+
                "Outside Temp Gauge|"+
                "Analog Appearance|"+
                "Manual Adjustable Front Head Restraints and Foldable Rear Head Restraints|"+
                "Front Center Armrest w/Storage|"+
                "2 Seatback Storage Pockets|"+
                "Perimeter Alarm|"+
                "2 12V DC Power Outlets and 1 120V AC Power Outlet|"+
                "Air Filtration|"+
                "Electronic Stability Control (ESC) And Roll Stability Control (RSC)|"+
                "ABS And Driveline Traction Control|"+
                "Side Impact Beams|"+
                "Dual Stage Driver And Passenger Seat-Mounted Side Airbags|"+
                "Tire Specific Low Tire Pressure Warning|"+
                "Dual Stage Driver And Passenger Front Airbags|"+
                "Airbag Occupancy Sensor|"+
                "Rear Child Safety Locks|"+
                "Outboard Front Lap And Shoulder Safety Belts -inc: Rear Center 3 Point, Height Adjusters and Pretensioners|"+
                "ParkView Back-Up Camera|";

        FeatureParser.parseFeature(data);
    }
}
