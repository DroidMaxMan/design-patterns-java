/*
 * ************************************************************************
 *  Copyright (c) 2018 @alxgcrz <alxgcrz@outlook.com>
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 * ***********************************************************************
 */

package behavioral.template;

import behavioral.template.example.CheckersPlayer;
import behavioral.template.example.ChessPlayer;
import behavioral.template.example.GamePlayer;

public class TemplateMethod {

    public static void main(String[] args) {

        GamePlayer chessGame = new ChessPlayer();
        System.out.println("[CHESS]");

        chessGame.play();

        GamePlayer checkersPlayer = new CheckersPlayer();
        System.out.println("[CHECKERS]");

        checkersPlayer.play();
    }

}
