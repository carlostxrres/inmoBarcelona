package com.ironhack.inmoBarcelona;

import com.ironhack.inmoBarcelona.enums.Orientation;
import com.ironhack.inmoBarcelona.models.*;
import com.ironhack.inmoBarcelona.enums.PropertyStatus;
import com.ironhack.inmoBarcelona.services.impl.UserService;
import com.ironhack.inmoBarcelona.services.impl.PropertyService;
import com.ironhack.inmoBarcelona.services.impl.AddressService;
import com.ironhack.inmoBarcelona.services.impl.NeighborhoodService;
import com.ironhack.inmoBarcelona.services.impl.StreetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@SpringBootApplication
public class inmoBarcelonaApplication {

    public static void main(String[] args) {
        SpringApplication.run(inmoBarcelonaApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UserService userService, PropertyService propertyService, AddressService addressService, NeighborhoodService neighborhoodService, StreetService streetService) {
        return args -> {

            // Create roles
            userService.saveRole(new Role(null, "ROLE_BUYER"));
            userService.saveRole(new Role(null, "ROLE_SELLER"));
            userService.saveRole(new Role(null, "ROLE_ADMIN"));

            // Create users (buyers and admins)
            userService.saveUser(new User("Maria Garcia", "mgarcia", "1234", new ArrayList<>(), new HashSet<>()));
            userService.saveUser(new User("Carlos Martínez", "cmartinez", "1234", new ArrayList<>(), new HashSet<>()));
            userService.saveUser(new User("Josep Lopez", "jlopez", "1234", new ArrayList<>(), new HashSet<>()));
            userService.saveUser(new User("Jordi Hernandez", "jhernandez", "1234", new ArrayList<>(), new HashSet<>()));
            userService.saveUser(new User("Mercedes Sanchez", "msanchez", "1234", new ArrayList<>(), new HashSet<>()));
            userService.saveUser(new User("Marc Salvado", "msalva", "1234", new ArrayList<>(), new HashSet<>()));
            userService.saveUser(new User("Catalina Gomez", "cgomez", "1234", new ArrayList<>(), new HashSet<>()));
            userService.saveUser(new User("Isabel Torres", "itorres", "1234", new ArrayList<>(), new HashSet<>()));
            userService.saveUser(new User("Miguel Ruiz", "mruiz", "1234", new ArrayList<>(), new HashSet<>()));
            userService.saveUser(new User("Montserrat Ferret", "mferret", "1234", new ArrayList<>(), new HashSet<>()));

            userService.addRoleToUser("mgarcia", "ROLE_BUYER");
            userService.addRoleToUser("cmartinez", "ROLE_ADMIN");
            userService.addRoleToUser("jlopez", "ROLE_BUYER");
            userService.addRoleToUser("jhernandez", "ROLE_ADMIN");
            userService.addRoleToUser("msanchez", "ROLE_BUYER");
            userService.addRoleToUser("msalva", "ROLE_BUYER");
            userService.addRoleToUser("cgomez", "ROLE_ADMIN");
            userService.addRoleToUser("itorres", "ROLE_BUYER");
            userService.addRoleToUser("mruiz", "ROLE_ADMIN");
            userService.addRoleToUser("mferret", "ROLE_BUYER");

            // Create Sellers
            User lydill = new User("Clyde Gill", "lydill", "1234", new ArrayList<>(), new HashSet<>());
            User ugeren = new User("Eugenia French", "ugeren", "1234", new ArrayList<>(), new HashSet<>());
            User ernran = new User("Bernard Franklin", "ernran", "1234", new ArrayList<>(), new HashSet<>());
            User euleor = new User("Beulah George", "euleor", "1234", new ArrayList<>(), new HashSet<>());

            userService.saveUser(lydill);
            userService.saveUser(ugeren);
            userService.saveUser(ernran);
            userService.saveUser(euleor);

            userService.addRoleToUser("lydill", "ROLE_SELLER");
            userService.addRoleToUser("ugeren", "ROLE_SELLER");
            userService.addRoleToUser("ernran", "ROLE_SELLER");
            userService.addRoleToUser("euleor", "ROLE_SELLER");

            // Create Neighborhoods
            Neighborhood barriGotic = new Neighborhood();
            Neighborhood eixample = new Neighborhood();
            Neighborhood gracia = new Neighborhood();
            Neighborhood santAntoni = new Neighborhood();
            Neighborhood elFortPienc = new Neighborhood();
            Neighborhood sagradaFamilia = new Neighborhood();
            Neighborhood poblenou = new Neighborhood();
            Neighborhood lesCorts = new Neighborhood();
            Neighborhood santMarti = new Neighborhood();
            Neighborhood santsMontjuic = new Neighborhood();
            Neighborhood hortaGuinardo = new Neighborhood();

            santAntoni.setNeighborhoodName("Sant Antoni");
            santAntoni.setDescription("Sant Antoni is a vibrant neighborhood known for its market, the Mercat de Sant Antoni, which is a central hub of activity. It's also home to many trendy restaurants, bars, and boutiques.");
            neighborhoodService.saveNeighborhood(santAntoni);

            elFortPienc.setNeighborhoodName("El Fort Pienc");
            elFortPienc.setDescription("El Fort Pienc is a neighborhood in the Eixample district of Barcelona. Its name comes from a fort that was built during the siege of Barcelona in 1714. Nowadays, it's known for the National Theatre of Catalonia and the Barcelona Auditorium.");
            neighborhoodService.saveNeighborhood(elFortPienc);

            sagradaFamilia.setNeighborhoodName("Sagrada Familia");
            sagradaFamilia.setDescription("The Sagrada Familia neighborhood is named after the Basilica of the Sagrada Familia, one of Barcelona's most famous landmarks. It's a quiet residential area with plenty of shops, cafes, and restaurants.");
            neighborhoodService.saveNeighborhood(sagradaFamilia);

            poblenou.setNeighborhoodName("Poblenou");
            poblenou.setDescription("Once an industrial area, Poblenou has transformed into a district of culture and creativity. It's full of tech companies, co-working spaces, art galleries, and unique restaurants, with a blend of old and new architectural styles.");
            neighborhoodService.saveNeighborhood(poblenou);

            lesCorts.setNeighborhoodName("Les Corts");
            lesCorts.setDescription("Les Corts is known for being the financial district of Barcelona and the location of Camp Nou, the stadium of FC Barcelona. It's a green residential area with plenty of parks, shops, and restaurants.");
            neighborhoodService.saveNeighborhood(lesCorts);

            santMarti.setNeighborhoodName("Sant Martí");
            santMarti.setDescription("Sant Martí is a diverse district home to both residential and commercial areas. It's known for its beaches, parks, and modern buildings such as the iconic Agbar Tower.");
            neighborhoodService.saveNeighborhood(santMarti);

            santsMontjuic.setNeighborhoodName("Sants-Montjuïc");
            santsMontjuic.setDescription("Sants-Montjuïc is known for its cultural attractions like the Montjuïc Park, the Magic Fountain, and the Palau Sant Jordi. It's also the location of the main train station, Barcelona-Sants.");
            neighborhoodService.saveNeighborhood(santsMontjuic);

            hortaGuinardo.setNeighborhoodName("Horta-Guinardó");
            hortaGuinardo.setDescription("Horta-Guinardó is the third largest district of Barcelona and one of its greenest areas. It's known for its hills, the Parc del Laberint d'Horta, and offers spectacular views over the city.");
            neighborhoodService.saveNeighborhood(hortaGuinardo);

            barriGotic.setNeighborhoodName("Barri Gotic");
            barriGotic.setDescription("The Barri Gòtic, also known as the Gothic Quarter, is one of the oldest and most beautiful areas in Barcelona. It's known for its narrow, winding streets, historic buildings, and vibrant dining and nightlife scene.");
            neighborhoodService.saveNeighborhood(barriGotic);

            eixample.setNeighborhoodName("Eixample");
            eixample.setDescription("Eixample is a large district in Barcelona known for its grid-like layout. It is home to some of Barcelona's most famous tourist attractions, including the Sagrada Familia and Casa Batllo.");
            neighborhoodService.saveNeighborhood(eixample);

            gracia.setNeighborhoodName("Gracia");
            gracia.setDescription("Gracia is known for its bohemian vibe, with plenty of independent boutiques, art cinemas, and a variety of restaurants and bars. The neighborhood is also famous for the Park Güell, one of Gaudí’s major works.");
            neighborhoodService.saveNeighborhood(gracia);

            // Create Streets
            Street tamarit = new Street();
            Street ribes = new Street();
            Street lepant = new Street();
            Street pallars = new Street();
            Street passatgeBori = new Street();
            Street valencia = new Street();
            Street londres = new Street();
            Street equador = new Street();
            Street laMerce = new Street();
            Street verdi = new Street();
            Street ramblaDelPoblenou = new Street();
            Street laCreuCoberta = new Street();

            tamarit.setStreetName("Tamarit");
            streetService.saveStreet(tamarit);
            ribes.setStreetName("Ribes");
            streetService.saveStreet(ribes);
            lepant.setStreetName("Lepant");
            streetService.saveStreet(lepant);
            pallars.setStreetName("Pallars");
            streetService.saveStreet(pallars);
            passatgeBori.setStreetName("Passatge Bori");
            streetService.saveStreet(passatgeBori);
            valencia.setStreetName("Valencia");
            streetService.saveStreet(valencia);
            londres.setStreetName("Londres");
            streetService.saveStreet(londres);
            equador.setStreetName("Equador");
            streetService.saveStreet(equador);
            laMerce.setStreetName("La Merce");
            streetService.saveStreet(laMerce);
            verdi.setStreetName("Verdi");
            streetService.saveStreet(verdi);
            ramblaDelPoblenou.setStreetName("Rambla del Poblenou");
            streetService.saveStreet(ramblaDelPoblenou);
            laCreuCoberta.setStreetName("La Creu Coberta");
            streetService.saveStreet(laCreuCoberta);

            // Create Addresses
            Address address1 = new Address(santAntoni, tamarit, 104, 1, "1");
            Address address2 = new Address(elFortPienc, ribes, 75, 7, "1");
            Address address3 = new Address(sagradaFamilia, lepant, 213, 1, "1");
            Address address4 = new Address(poblenou, pallars, 139, 1, "1");
            Address address5 = new Address(poblenou, passatgeBori, 5, 3, "1");
            Address address6 = new Address(eixample, valencia, 251, 3, "A");
            Address address7 = new Address(eixample, londres, 273, 3, "C");
            Address address8 = new Address(lesCorts, equador, 58, 2, "1");
            Address address9 = new Address(barriGotic, laMerce, 11, 2, "A");
            Address address10 = new Address(gracia, verdi, 24, 4, "B");
            Address address11 = new Address(santMarti, ramblaDelPoblenou, 76, 1, "1");
            Address address12 = new Address(santsMontjuic, laCreuCoberta, 88, 3, "2");
            Address address13 = new Address(hortaGuinardo, lepant, 267, 5, "C");

            addressService.saveAddress(address1);
            addressService.saveAddress(address2);
            addressService.saveAddress(address3);
            addressService.saveAddress(address4);
            addressService.saveAddress(address5);
            addressService.saveAddress(address6);
            addressService.saveAddress(address7);
            addressService.saveAddress(address8);
            addressService.saveAddress(address9);
            addressService.saveAddress(address10);
            addressService.saveAddress(address11);
            addressService.saveAddress(address12);
            addressService.saveAddress(address13);

            // Create Properties
            propertyService.saveProperty(
                    new Property(
                            lydill,
                            new HashSet<>(),
                            address1,
                            89,
                            3,
                            450000,
                            "La vivienda está reformada con mucho gusto, con tonos cálidos y materiales de calidad. Es exterior, carpintería interior de madera y exterior climalit.",
                            PropertyStatus.RENOVATED,
                            LocalDate.of(2023, 2, 27),
                            Orientation.NORTH
                    )
            );
            propertyService.saveProperty(
                    new Property(
                            lydill,
                            new HashSet<>(),
                            address2,
                            100,
                            3,
                            395000,
                            "¡Se vende piso exclusivo en séptima planta con espectaculares vistas abiertas!",
                            PropertyStatus.GOOD_CONDITION,
                            LocalDate.of(2022, 12, 5),
                            Orientation.SOUTH
                    )
            );
            propertyService.saveProperty(
                    new Property(
                            lydill,
                            new HashSet<>(),
                            address3,
                            74,
                            1,
                            175000,
                            "Piso en planta entresuelo, no es un bajo. Piso con recibidor, salón comedor, dormitorio, baño y cocina. Buen estado general de la vivienda y de la comunidad.",
                            PropertyStatus.GOOD_CONDITION,
                            LocalDate.of(2023, 1, 12),
                            Orientation.NORTHEAST
                    )
            );
            propertyService.saveProperty(
                    new Property(
                            ugeren,
                            new HashSet<>(),
                            address4,
                            152,
                            3,
                            425000,
                            "La vivienda consta de 118,54 M2 construidos bajo techo y 34,25 m2 de patio y terrazas, y permite varias configuraciones qué pueden oscilar entre los dos y cuatro dormitorios según necesidades.",
                            PropertyStatus.OLD,
                            LocalDate.of(2023, 3, 29),
                            Orientation.WEST
                    )
            );
            propertyService.saveProperty(
                    new Property(
                            ernran,
                            new HashSet<>(),
                            address5,
                            50,
                            2,
                            240000,
                            "Presentamos en exclusiva este magnífico piso reformado de 50m2, en finca sin ascensor, en pleno centro del barrio de Poblenou, muy cerca de la playa.",
                            PropertyStatus.RENOVATED,
                            LocalDate.of(2023, 5, 6),
                            Orientation.NORTHEAST
                    )
            );
            propertyService.saveProperty(
                    new Property(
                            ernran,
                            new HashSet<>(),
                            address6,
                            102,
                            3,
                            525000,
                            "Fantástico piso, próximo al clínic, escuela industrial, piscinas St Jordi, Hospital Sagrat Cor, Mercado del Ninot. etc",
                            PropertyStatus.GOOD_CONDITION,
                            LocalDate.of(2023, 4, 15),
                            Orientation.SOUTHEAST
                    )
            );
            propertyService.saveProperty(
                    new Property(
                            euleor,
                            new HashSet<>(),
                            address7,
                            139,
                            4,
                            550000,
                            "La propiedad está distribuida en salón-comedor, cocina-office, tres habitaciones dobles (dos exteriores, una de ellas con salida a balcón y otra con vestidor) y dos baños completos.",
                            PropertyStatus.RENOVATED,
                            LocalDate.of(2023, 5, 17),
                            Orientation.NORTH
                    )
            );
            propertyService.saveProperty(
                    new Property(
                            euleor,
                            new HashSet<>(),
                            address8,
                            94,
                            2,
                            370000,
                            "Duran Carasso presenta este piso a reformar sito en el barrio de Les Corts, con una ubicación excelente, cerca de comercios, colegios, transportes, zonas verdes, y en una calle muy tranquila.",
                            PropertyStatus.RENOVATED,
                            LocalDate.of(2022, 12, 6),
                            Orientation.NORTH
                    )
            );
            propertyService.saveProperty(
                    new Property(
                            euleor,
                            new HashSet<>(),
                            address9,
                            85,
                            2,
                            300000,
                            "Un precioso piso situado en el corazón del barrio gótico, reformado y con mucha luz natural. Cuenta con dos habitaciones, cocina completa y salón amplio.",
                            PropertyStatus.RENOVATED,
                            LocalDate.of(2023, 2, 14),
                            Orientation.SOUTHEAST
                    )
            );
            propertyService.saveProperty(
                    new Property(
                            euleor,
                            new HashSet<>(),
                            address10,
                            95,
                            3,
                            350000,
                            "Encantador piso en el barrio de Gracia con tres habitaciones. Recientemente reformado con cocina y baño modernos.",
                            PropertyStatus.GOOD_CONDITION,
                            LocalDate.of(2023, 3, 19),
                            Orientation.WEST
                    )
            );
            propertyService.saveProperty(
                    new Property(
                            euleor,
                            new HashSet<>(),
                            address11,
                            120,
                            4,
                            450000,
                            "Amplio piso en la Rambla del Poblenou con cuatro habitaciones. Cocina completa y gran salón comedor con vistas a la Rambla.",
                            PropertyStatus.OLD,
                            LocalDate.of(2023, 4, 24),
                            Orientation.SOUTHEAST
                    )
            );
            propertyService.saveProperty(
                    new Property(
                            euleor,
                            new HashSet<>(),
                            address12,
                            100,
                            3,
                            400000,
                            "Piso en Sants-Montjuïc con tres habitaciones. Buen estado de conservación, cerca de parques y transporte público.",
                            PropertyStatus.GOOD_CONDITION,
                            LocalDate.of(2023, 5, 29),
                            Orientation.NORTH
                    )
            );
            propertyService.saveProperty(
                    new Property(
                            euleor,
                            new HashSet<>(),
                            address13,
                            110,
                            3,
                            410000,
                            "Agradable piso en Horta-Guinardó, tres habitaciones y gran salón comedor. Cocina independiente y dos baños. Preciosas vistas de la ciudad.",
                            PropertyStatus.GOOD_CONDITION,
                            LocalDate.of(2023, 6, 14),
                            Orientation.NORTHWEST
                    )
            );
        };
    }
}