/*
 * Copyright (c) 2018 @alxgcrz <alxgcrz@outlook.com>
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *        https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License
 */

package behavioral.reactor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import behavioral.reactor.example.ConcreteEventHandler;
import behavioral.reactor.example.Event;
import behavioral.reactor.example.EventHandler;


/**
 * Project: Learning_Design_Patterns_Java
 * Date: 28/09/15
 *
 * @author "Álex García (@alxgcrz) <alxgcrz@outlook.com"
 *
 *
 * Patrones de COMPORTAMIENTO
 * --------------------
 * Son los patrones de diseño software que se centran en cómo diseñar los sistemas para obtener cierta funcioanlidad y,
 * al mismo tiempo, un diseño escalable.
 *
 *
 * Pattern [Reactor] (Reactivo)
 *
 * Es un patrón arquitectural para resolver el problema de cómo atender peticiones concurrentes a través de señales y manejadores de señales.
 */
public class Reactor {

    /**
     * Manejadores registrados
     **/
    private static List<EventHandler> handlers = new ArrayList<>();


    /**
     * Registrar un manejador
     *
     * @param eventHandler to add
     */
    public static void regHandler( EventHandler eventHandler ) {
        handlers.add( eventHandler );
    }


    public static void main( String[] args ) {
        // Handler registration
        EventHandler eventHandler = new ConcreteEventHandler();
        regHandler( eventHandler );

        // Bucle
        while ( true ) {
            // Simulate event
            if ( new Random().nextInt( 10000000 ) == 50 ) {
                // Event occurs.
                Event event = new Event();
                // Notify
                for ( EventHandler handler : handlers ) {
                    handler.handle( event );
                }
            }
        }
    }
}
