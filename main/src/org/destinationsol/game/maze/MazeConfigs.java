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

package org.destinationsol.game.maze;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import org.destinationsol.TextureManager;
import org.destinationsol.assets.AssetHelper;
import org.destinationsol.assets.json.Json;
import org.destinationsol.files.FileManager;
import org.destinationsol.files.HullConfigManager;
import org.destinationsol.game.item.ItemManager;
import org.terasology.assets.ResourceUrn;

import java.util.ArrayList;
import java.util.List;

public class MazeConfigs {
    public final List<MazeConfig> configs;

    public MazeConfigs(TextureManager textureManager, HullConfigManager hullConfigs, ItemManager itemManager, AssetHelper assetHelper) {
        configs = new ArrayList<>();

        Json json = assetHelper.getJson(new ResourceUrn("Core:mazesConfig"));
        JsonValue rootNode = json.getJsonValue();

        for (JsonValue mazeNode : rootNode) {
            MazeConfig c = MazeConfig.load(textureManager, hullConfigs, mazeNode, itemManager, assetHelper);
            configs.add(c);
        }

        json.dispose();
    }
}
