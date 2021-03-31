import org.testng.annotations.Test;
import org.testng.Assert;


public class FeatureTest {

    @Test
    public void testcase_1(){
        String testData = "AM/FM Stereo|Audio system feature, 6-speaker system|Auxiliary Audio Input|MP3 Player|Noise control system, active noise cancellation|Satellite Radio|Smart Device Integration|Door handles, body-color with chrome strip|Glass, acoustic, laminated windshield|Glass, laminated front doors|Headlamp control, automatic on and off|Headlamps, automatic delay|Headlamps, halogen composite with automatic exterior lamp control|License plate front mounting package|Memory settings, includes presets for driver seat adjuster and outside rearview mirror|Mirror, inside rearview auto-dimming|Mirrors, outside heated power-adjustable, body-color, manual-folding with turn signal indicators and driver side auto-dimming|Tire Pressure Monitoring System|Tire, spare T145/70R17 SL blackwall|Tires, P225/60R18 all-season blackwall|Wheel, 17\" (43.2 cm) steel spare|Wheels, 18\" (45.7 cm) 10-spoke polished aluminum|Air conditioning, tri-zone automatic climate control with individual climate settings for driver, front passenger and rear seat";
//        Assert.assertEquals(Feature.readFeature(testData));
        Feature.readFeature(testData);
    }

    @Test
    public void testcase_2(){
        String testData = "6 Speakers|AM/FM radio: SiriusXM|CD player|MP3 decoder|Radio: Entune Audio Display AM/FM/HD w/CD Player|Air Conditioning|Power steering|Power windows|Remote keyless entry|Speed-sensing steering|Traction control|4-Wheel Disc Brakes|ABS brakes|Dual front impact airbags|Dual front side impact airbags|Front anti-roll bar|Front wheel independent suspension|Knee airbag|Low tire pressure warning|Occupant sensing airbag|Overhead airbag|Brake assist|Electronic Stability Control|Exterior Parking Camera Rear|Front fog lights|Panic alarm|Speed control|Front Fog & Daytime Running Lights|Heated door mirrors|Power door mirrors|Rear step bumper|Driver door bin|Driver vanity mirror|Front reading lights|Illuminated entry|Illuminated Entry System|Outside temperature display|Overhead console|Passenger vanity mirror|Rear reading lights|Tachometer|Tilt steering wheel|Voltmeter|3-Passenger Front Bench Seat|Fabric Seat Trim|Rear Under-Seat Storage Compartment|Split folding rear seat|Front Center Armrest w/Storage|Passenger door bin|…";
        Feature.readFeature(testData);
    }

    @Test
    public void testcase_3(){
        String testData = "1 LCD Monitor In The Front|" +
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
        Assert.assertEquals(Feature.readFeature(testData), "test");
    }

    @Test
    public void testcase4() {
        String data = "A/c condi|" +
                "AM/FM/CD|" +
                "Strip/Fascia";

        Feature.readFeature(data);
    }

}
