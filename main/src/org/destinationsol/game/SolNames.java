/*
 * Copyright 2015 MovingBlocks
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.destinationsol.game;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.JsonValue;
import org.destinationsol.assets.AssetHelper;
import org.destinationsol.assets.json.Json;
import org.destinationsol.files.FileManager;
import org.terasology.assets.ResourceUrn;

import java.util.ArrayList;

public class SolNames {
    public final ArrayList<String> planets;
    public final ArrayList<String> systems;

    public SolNames(AssetHelper assetHelper) {
        planets = readList(new ResourceUrn("Core:planetNamesConfig"), assetHelper);
        systems = readList(new ResourceUrn("Core:systemNamesConfig"), assetHelper);
    }

    private ArrayList<String> readList(ResourceUrn fileName, AssetHelper assetHelper) {
        Json json = assetHelper.getJson(fileName);
        JsonValue rootNode = json.getJsonValue();

        ArrayList<String> list = new ArrayList<>();
        for (JsonValue node : rootNode) {
            list.add(node.name());
        }

        json.dispose();

        return list;
    }
}
