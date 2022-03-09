/*
 *  This file is part of AndroidIDE.
 *
 *  AndroidIDE is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  AndroidIDE is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *   along with AndroidIDE.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.itsaky.androidide.fragments.attr;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.ArrayList;

/**
 * @author Akash Yadav
 */
public class FlagEditor extends FixedValueEditor {
    
    @Override
    public void onViewCreated (@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated (view, savedInstanceState);
    }
    
    @Override
    protected void onCheckChanged (@NonNull ChipGroup group, int checkedId) {
        final var checked = group.getCheckedChipIds ();
        final var items = new ArrayList<String> ();
        if (!checked.isEmpty ()) {
            for (var id : checked) {
                final var chip = (Chip) group.findViewById (id);
                final var val = chip.getText ().toString ().trim ();
                items.add (val);
            }
            
            notifyValueChanged (TextUtils.join ("|", items));
        }
    }
}