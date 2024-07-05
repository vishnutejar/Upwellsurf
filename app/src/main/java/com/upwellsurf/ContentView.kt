package com.upwellsurf

import com.upwellsurf.models.SurfSpot
import com.upwellsurf.models.SurfSpotForecast


class ContentView {
    private val searchText = ""

    // Initialize the surf spot and forecast lists
    private val costaRicaSurfSpots: MutableList<SurfSpot> = ArrayList()
    private val puertoRicoSurfSpotForecasts: MutableList<SurfSpotForecast>
     val surfSpots: MutableList<SurfSpot>
     val surfSpotForecasts: MutableList<SurfSpotForecast>

    init {
        costaRicaSurfSpots.add(SurfSpot("Tamarindo", "Guanacaste", "Costa Rica", "tamarindo_image"))
        costaRicaSurfSpots.add(
            SurfSpot(
                "Playa Hermosa",
                "Guanacaste",
                "Costa Rica",
                "playa_hermosa_image"
            )
        )
        costaRicaSurfSpots.add(
            SurfSpot(
                "Santa Teresa",
                "Puntarenas",
                "Costa Rica",
                "santa_teresa_image"
            )
        )

        puertoRicoSurfSpotForecasts = ArrayList()
        puertoRicoSurfSpotForecasts.add(
            SurfSpotForecast(
                "Rincón",
                "3-4 ft with moderate offshore winds. Good conditions for surfing.",
                "Buoy report data for Rincón",
                18.3405,
                -67.2503
            )
        )
        puertoRicoSurfSpotForecasts.add(
            SurfSpotForecast(
                "Jobos",
                "2-3 ft with light onshore winds. Fair conditions for surfing.",
                "Buoy report data for Jobos",
                18.5002,
                -67.0286
            )
        )
        puertoRicoSurfSpotForecasts.add(
            SurfSpotForecast(
                "Tres Palmas",
                "4-5 ft with strong offshore winds. Excellent conditions for advanced surfers.",
                "Buoy report data for Tres Palmas",
                18.3458,
                -67.2687
            )
        )
        puertoRicoSurfSpotForecasts.add(
            SurfSpotForecast(
                "Gas Chambers",
                "3-4 ft with moderate onshore winds. Fair conditions for surfing.",
                "Buoy report data for Gas Chambers",
                18.5002,
                -67.0286
            )
        )

        // Initialize other surf spot and forecast lists similarly
        surfSpots = ArrayList()
        surfSpots.add(SurfSpot("Lawrencetown", "Nova Scotia", "Canada", "lawrencetown_image"))
        surfSpots.add(SurfSpot("TeaHouse", "Eastern Shore", "Canada", "teahouse_image"))
        surfSpots.add(
            SurfSpot(
                "Rainbow Haven Beach",
                "CowBay",
                "Canada",
                "rainbow_haven_beach_image"
            )
        )
        surfSpots.add(SurfSpot("Mic Mac Lake ", "Dartmouth", "Canada", "mic_mac_lake_image"))
        surfSpots.add(SurfSpot("The Moose", "Eastern Shore", "Canada", "moose_image"))
        surfSpots.add(SurfSpot("The Cove", "Eastern Shore", "Canada", "cove_image"))
        surfSpots.add(SurfSpot("Shubie Park", "Dartmouth", "Nova Scotia", "Shubie_Park_image"))
        surfSpots.add(
            SurfSpot(
                "Halifax Harbour ",
                "Dartmouth",
                "Nova Scotia",
                "halifax_harbour_image"
            )
        )
        surfSpots.add(SurfSpot("Chester", "South Shore", "Nova Scotia", "chester_image"))
        surfSpots.add(
            SurfSpot(
                "Kind of Sketchy",
                "East Iron bound",
                "Nova Scotia",
                "KindofSketchy_image"
            )
        )
        surfSpots.add(
            SurfSpot(
                "Martinique Beach",
                "Nova Scotia",
                "Canada",
                "martinique_beach_image"
            )
        )
        surfSpots.add(SurfSpot("Jeddore Harbour", "Nova Scotia", "Canada", "jeddore_harbour_image"))
        surfSpots.add(SurfSpot("Clam Harbour", "Nova Scotia", "Canada", "clam_harbour_image"))
        surfSpots.add(
            SurfSpot(
                "Pictou Island Beach ",
                "Nova Scotia",
                "Canada",
                " pictou_island_beach_image"
            )
        )
        surfSpots.add(SurfSpot("Taylor's Head", "Nova Scotia", "Canada", "taylors_head_image"))
        surfSpots.add(SurfSpot("Sheet Harbour", "Nova Scotia", "Canada", "sheet_harbour_image"))
        surfSpots.add(SurfSpot("Wine Harbour", "Nova Scotia", "Canada", "wine_habour_image"))
        surfSpots.add(SurfSpot("Point Bickerton", "Nova Scotia", "Canada", "point_bickerton_image"))
        surfSpots.add(SurfSpot("Lake Williams", "Nova Scotia", "Canada", "lake_williams_image"))
        surfSpots.add(SurfSpot("Grand Lake", "Nova Scotia", "Canada", "grand_lake_image"))
        surfSpots.add(
            SurfSpot(
                "Crescent Beach",
                "South Shore",
                "Nova Scotia",
                "crescent_beach_image"
            )
        )
        surfSpots.add(SurfSpot("Bondi Beach", "Sydney", "Australia", "bondi_image"))
        surfSpots.add(SurfSpot("Pipeline", "Oahu", "Hawaii", "pipeline_image"))
        surfSpots.add(SurfSpot("Soup Bowl", "Bathsheba", "Barbados", "soup_bowl_image"))
        surfSpots.add(SurfSpot("Freights Bay", "Christ Church", "Barbados", "freights_bay_image"))
        surfSpots.add(SurfSpot("Tofino", "Vancouver Island", "Canada", "tofino_image"))
        surfSpots.add(SurfSpot("Jordan River", "Vancouver Island", "Canada", "jordan_river_image"))
        surfSpots.add(SurfSpot("Bamburgh", "UK ", "England", "bamburgh_image,"))
        surfSpots.add(SurfSpot("Monuments", "Cabo", "Mexico", "monuments_image"))
        surfSpots.add(SurfSpot("Malibu", "California", "USA", "malibu_image"))
        surfSpots.add(SurfSpot("Huntington Beach", "California", "USA", "huntington_beach_image"))
        surfSpots.add(SurfSpot("Santa Cruz", "California", "USA", "santa_cruz_image"))
        surfSpots.add(SurfSpot("San Clemente", "California", "USA", "san_clemente_image"))
        surfSpots.add(SurfSpot("Pacific Beach", "California", "USA", "pacific_beach_image"))
        surfSpots.add(SurfSpot("Ocean Beach", "California", "USA", "ocean_beach_image"))
        surfSpots.add(
            SurfSpot(
                "Cerritos Beach",
                "Cabo San Lucas",
                "Mexico",
                "cerritos_beach_image"
            )
        )
        surfSpots.add(SurfSpot("Monuments", "San José del Cabo", "Mexico", "monuments_image"))
        surfSpots.add(SurfSpot("Marquette", "Lake Superior", "USA", "marquette_image"))
        surfSpots.add(SurfSpot("New Buffalo", "Lake Michigan", "USA", "new_buffalo_image"))
        surfSpots.add(SurfSpot("Tawas Bay", "Lake Huron", "USA", "tawas_bay_image"))
        surfSpots.add(SurfSpot("Presque Isle", "Lake Erie", "USA", "presque_isle_image"))
        surfSpots.add(SurfSpot("Rochester", "Lake Ontario", "USA", "rochester_image"))
        surfSpots.add(SurfSpot("Cannon Beach", "Oregon", "USA", "cannon_beach_image"))
        surfSpots.add(SurfSpot("Seaside", "Oregon", "USA", "seaside_image"))
        surfSpots.add(SurfSpot("Lincoln City", "Oregon", "USA", "lincoln_city_image"))
        surfSpots.add(SurfSpot("Pacific City", "Oregon", "USA", "pacific_city_image"))
        surfSpots.add(SurfSpot("Manzanita", "Oregon", "USA", "manzanita_image"))
        surfSpots.add(SurfSpot("Bandon", "Oregon", "USA", "bandon_image"))
        surfSpots.add(SurfSpot("Winchester Bay", "Oregon", "USA", "winchester_bay_image"))
        surfSpots.add(SurfSpot("Florence", "Oregon", "USA", "florence_image"))
        surfSpots.add(SurfSpot("Gold Beach", "Oregon", "USA", "gold_beach_image"))
        surfSpots.add(SurfSpot("Cocoa Beach", "Florida", "USA", "cocoa_beach_image"))
        surfSpots.add(SurfSpot("Daytona Beach", "Florida", "USA", "daytona_beach_image"))
        surfSpots.add(SurfSpot("New Smyrna Beach", "Florida", "USA", "new_smyrna_beach_image"))
        surfSpots.add(SurfSpot("Flagler Beach", "Florida", "USA", "flagler_beach_image"))
        surfSpots.add(SurfSpot("Palm Beach", "Florida", "USA", "palm_beach_image"))
        surfSpots.add(SurfSpot("Jupiter Inlet", "Florida", "USA", "jupiter_inlet_image"))
        surfSpots.add(SurfSpot("Sebastian Inlet", "Florida", "USA", "sebastian_inlet_image"))
        surfSpots.add(SurfSpot("South Beach", "Miami", "USA", "south_beach_image"))

        surfSpotForecasts = ArrayList()
        surfSpotForecasts.add(
            SurfSpotForecast(
                "Tamarindo",
                "3-5 ft with light offshore winds. Excellent conditions for beginners.",
                "Buoy report data for Tamarindo",
                10.2998,
                -85.8414
            )
        )
        surfSpotForecasts.add(
            SurfSpotForecast(
                "Playa Hermosa",
                "4-6 ft with moderate offshore winds. Great conditions for experienced surfers.",
                "Buoy report data for Playa Hermosa",
                9.6281,
                -85.1617
            )
        )
        surfSpotForecasts.add(
            SurfSpotForecast(
                "Santa Teresa",
                "2-4 ft with strong offshore winds. Good conditions for intermediate surfers.",
                "Buoy report data for Santa Teresa",
                9.6457,
                -85.1671
            )
        )
        surfSpotForecasts.add(
            SurfSpotForecast(
                "Rincón",
                "3-4 ft with moderate offshore winds. Good conditions for surfing.",
                "Buoy report data for Rincón",
                18.3405,
                -67.2503
            )
        )
        surfSpotForecasts.add(
            SurfSpotForecast(
                "Jobos",
                "2-3 ft with light onshore winds. Fair conditions for surfing.",
                "Buoy report data for Jobos",
                18.5002,
                -67.0286
            )
        )
        surfSpotForecasts.add(
            SurfSpotForecast(
                "Tres Palmas",
                "4-5 ft with strong offshore winds. Excellent conditions for advanced surfers.",
                "Buoy report data for Tres Palmas",
                18.3458,
                -67.2687
            )
        )
        surfSpotForecasts.add(
            SurfSpotForecast(
                "Gas Chambers",
                "3-4 ft with moderate onshore winds. Fair conditions for surfing.",
                "Buoy report data for Gas Chambers",
                18.5002,
                -67.0286
            )
        )
        surfSpotForecasts.add(
            SurfSpotForecast(
                "Lawrencetown",
                "4-5 ft with moderate offshore winds. Good conditions for intermediate surfers.",
                "Buoy report data for Lawrencetown",
                44.6683,
                -63.3544
            )
        )
        surfSpotForecasts.add(
            SurfSpotForecast(
                "TeaHouse",
                "3-4 ft with light onshore winds. Fair conditions for beginners.",
                "Buoy report data for TeaHouse",
                44.7121,
                -63.1384
            )
        )
        surfSpotForecasts.add(
            SurfSpotForecast(
                "Rainbow Haven Beach",
                "2-3 ft with light onshore winds. Fair conditions for beginners.",
                "Buoy report data for Rainbow Haven Beach",
                44.6365,
                -63.4340
            )
        )
        surfSpotForecasts.add(
            SurfSpotForecast(
                "Mic Mac Lake",
                "3-4 ft with light offshore winds. Good conditions for beginners.",
                "Buoy report data for Mic Mac Lake",
                44.6990,
                -63.5804
            )
        )
        surfSpotForecasts.add(
            SurfSpotForecast(
                "The Moose",
                "3-4 ft with light offshore winds. Good conditions for beginners.",
                "Buoy report data for The Moose",
                44.7158,
                -63.1382
            )
        )
        surfSpotForecasts.add(
            SurfSpotForecast(
                "The Cove",
                "4-5 ft with moderate offshore winds. Good conditions for intermediate surfers.",
                "Buoy report data for The Cove",
                44.7054,
                -63.0726
            )
        )
        surfSpotForecasts.add(
            SurfSpotForecast(
                "Shubie Park",
                "4-5 ft with moderate offshore winds. Good conditions for intermediate surfers.",
                "Buoy report data for Shubie Park",
                44.6909,
                -63.5807
            )
        )
        surfSpotForecasts.add(
            SurfSpotForecast(
                "Halifax Harbour",
                "2-3 ft with light offshore winds. Good conditions for beginners.",
                "Buoy report data for Halifax Harbour",
                44.6478,
                -63.5712
            )
        )
        surfSpotForecasts.add(
            SurfSpotForecast(
                "Chester",
                "3-4 ft with light offshore winds. Good conditions for beginners.",
                "Buoy report data for Chester",
                44.5362,
                -64.2455
            )
        )
        surfSpotForecasts.add(
            SurfSpotForecast(
                "Kind of Sketchy",
                "4-5 ft with moderate offshore winds. Good conditions for intermediate surfers.",
                "Buoy report data for Kind of Sketchy",
                44.5530,
                -63.2471
            )
        )
        surfSpotForecasts.add(
            SurfSpotForecast(
                "Martinique Beach",
                "3-4 ft with light onshore winds. Fair conditions for beginners.",
                "Buoy report data for Martinique Beach",
                44.7016,
                -63.0060
            )
        )
        surfSpotForecasts.add(
            SurfSpotForecast(
                "Jeddore Harbour",
                "3-4 ft with light onshore winds. Fair conditions for beginners.",
                "Buoy report data for Jeddore Harbour",
                44.7960,
                -63.0845
            )
        )
        surfSpotForecasts.add(
            SurfSpotForecast(
                "Clam Harbour",
                "4-5 ft with moderate offshore winds. Good conditions for intermediate surfers.",
                "Buoy report data for Clam Harbour",
                44.7230,
                -63.1096
            )
        )
        surfSpotForecasts.add(
            SurfSpotForecast(
                "Pictou Island Beach",
                "4-5 ft with moderate offshore winds. Good conditions for intermediate surfers.",
                "Buoy report data for Pictou Island Beach",
                44.7285,
                -63.3134
            )
        )
        surfSpotForecasts.add(
            SurfSpotForecast(
                "Taylor's Head",
                "2-3 ft with light onshore winds. Fair conditions for beginners.",
                "Buoy report data for Taylor's Head",
                44.8148,
                -63.0150
            )
        )
        surfSpotForecasts.add(
            SurfSpotForecast(
                "Sheet Harbour",
                "3-4 ft with light offshore winds. Good conditions for beginners.",
                "Buoy report data for Sheet Harbour",
                44.9173,
                -62.5350
            )
        )
        surfSpotForecasts.add(
            SurfSpotForecast(
                "Wine Harbour",
                "3-4 ft with light offshore winds. Good conditions for beginners.",
                "Buoy report data for Wine Harbour",
                45.1092,
                -62.3602
            )
        )
        surfSpotForecasts.add(
            SurfSpotForecast(
                "Point Bickerton",
                "4-5 ft with moderate offshore winds. Good conditions for intermediate surfers.",
                "Buoy report data for Point Bickerton",
                45.0774,
                -62.0478
            )
        )
        surfSpotForecasts.add(
            SurfSpotForecast(
                "Lake Williams",
                "4-5 ft with moderate offshore winds. Good conditions for intermediate surfers.",
                "Buoy report data for Lake Williams",
                44.6930,
                -63.6222
            )
        )
        surfSpotForecasts.add(
            SurfSpotForecast(
                "Grand Lake",
                "2-3 ft with light onshore winds. Fair conditions for beginners.",
                "Buoy report data for Grand Lake",
                44.7147,
                -63.5844
            )
        )
        surfSpotForecasts.add(
            SurfSpotForecast(
                "Crescent Beach",
                "3-4 ft with light offshore winds. Good conditions for beginners.",
                "Buoy report data for Crescent Beach",
                44.6982,
                -63.6930
            )
        )
        surfSpotForecasts.add(
            SurfSpotForecast(
                "Bondi Beach",
                "3-4 ft with light offshore winds. Good conditions for beginners.",
                "Buoy report data for Bondi Beach",
                -33.8915,
                151.2767
            )
        )
        surfSpotForecasts.add(
            SurfSpotForecast(
                "Pipeline",
                "4-5 ft with moderate offshore winds. Good conditions for intermediate surfers.",
                "Buoy report data for Pipeline",
                21.6655,
                -158.0506
            )
        )
        surfSpotForecasts.add(
            SurfSpotForecast(
                "Soup Bowl",
                "2-3 ft with light onshore winds. Fair conditions for beginners.",
                "Buoy report data for Soup Bowl",
                13.2117,
                -59.5256
            )
        )
        surfSpotForecasts.add(
            SurfSpotForecast(
                "Freights Bay",
                "3-4 ft with light offshore winds. Good conditions for beginners.",
                "Buoy report data for Freights Bay",
                13.0940,
                -59.6102
            )
        )
        surfSpotForecasts.add(
            SurfSpotForecast(
                "Seaside",
                "2-3 ft with light onshore winds. Fair conditions for beginners.",
                "Buoy report data for Seaside",
                45.9935,
                -123.9223
            )
        )
        surfSpotForecasts.add(
            SurfSpotForecast(
                "Lincoln City",
                "3-4 ft with light offshore winds. Good conditions for beginners.",
                "Buoy report data for Lincoln City",
                44.9582,
                -124.0179
            )
        )
        surfSpotForecasts.add(
            SurfSpotForecast(
                "Pacific City",
                "4-5 ft with moderate offshore winds. Good conditions for intermediate surfers.",
                "Buoy report data for Pacific City",
                45.2107,
                -123.9630
            )
        )
        surfSpotForecasts.add(
            SurfSpotForecast(
                "Manzanita",
                "2-3 ft with light onshore winds. Fair conditions for beginners.",
                "Buoy report data for Manzanita",
                45.7190,
                -123.9350
            )
        )
        surfSpotForecasts.add(
            SurfSpotForecast(
                "Bandon",
                "3-4 ft with light offshore winds. Good conditions for beginners.",
                "Buoy report data for Bandon",
                43.1209,
                -124.4081
            )
        )
        surfSpotForecasts.add(
            SurfSpotForecast(
                "Winchester Bay",
                "4-5 ft with moderate offshore winds. Good conditions for intermediate surfers.",
                "Buoy report data for Winchester Bay",
                43.6846,
                -124.1961
            )
        )
        surfSpotForecasts.add(
            SurfSpotForecast(
                "Florence",
                "2-3 ft with light onshore winds. Fair conditions for beginners.",
                "Buoy report data for Florence",
                43.9826,
                -124.0998
            )
        )
        surfSpotForecasts.add(
            SurfSpotForecast(
                "Gold Beach",
                "3-4 ft with light offshore winds. Good conditions for beginners.",
                "Buoy report data for Gold Beach",
                42.4072,
                -124.4218
            )
        )
        surfSpotForecasts.add(
            SurfSpotForecast(
                "Cocoa Beach",
                "2-3 ft with light onshore winds. Fair conditions for beginners.",
                "Buoy report data for Cocoa Beach",
                28.3170,
                -80.6076
            )
        )
        surfSpotForecasts.add(
            SurfSpotForecast(
                "Daytona Beach",
                "3-4 ft with light offshore winds. Good conditions for beginners.",
                "Buoy report data for Daytona Beach",
                29.2108,
                -81.0228
            )
        )
        surfSpotForecasts.add(
            SurfSpotForecast(
                "New Smyrna Beach",
                "4-5 ft with moderate offshore winds. Good conditions for intermediate surfers.",
                "Buoy report data for New Smyrna Beach",
                29.0258,
                -80.9283
            )
        )
        surfSpotForecasts.add(
            SurfSpotForecast(
                "Flagler Beach",
                "2-3 ft with light onshore winds. Fair conditions for beginners.",
                "Buoy report data for Flagler Beach",
                29.4746,
                -81.1278
            )
        )
        surfSpotForecasts.add(
            SurfSpotForecast(
                "Palm Beach",
                "3-4 ft with light offshore winds. Good conditions for beginners.",
                "Buoy report data for Palm Beach",
                26.7056,
                -80.0364
            )
        )
        surfSpotForecasts.add(
            SurfSpotForecast(
                "Jupiter Inlet",
                "4-5 ft with moderate offshore winds. Good conditions for intermediate surfers.",
                "Buoy report data for Jupiter Inlet",
                26.9489,
                -80.0788
            )
        )
        surfSpotForecasts.add(
            SurfSpotForecast(
                "Sebastian Inlet",
                "2-3 ft with light onshore winds. Fair conditions for beginners.",
                "Buoy report data for Sebastian Inlet",
                27.8599,
                -80.4472
            )
        )
        surfSpotForecasts.add(
            SurfSpotForecast(
                "South Beach",
                "3-4 ft with light offshore winds. Good conditions for beginners.",
                "Buoy report data for South Beach",
                25.7826,
                -80.1341
            )
        )
    }
}