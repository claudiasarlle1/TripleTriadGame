package cat.udl.hyperion.appmobils.tripletriad;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cat.udl.hyperion.appmobils.tripletriad.databinding.FragmentBoardBinding;
import cat.udl.hyperion.appmobils.tripletriad.databinding.FragmentCellBinding;
import cat.udl.hyperion.appmobils.tripletriad.models.Card;
import cat.udl.hyperion.appmobils.tripletriad.viewmodels.BoardViewModel;
import cat.udl.hyperion.appmobils.tripletriad.viewmodels.DeckViewModel;

public class BoardFragment extends Fragment implements OnCellClickListener{

    private BoardViewModel boardViewModel;

    private FragmentBoardBinding binding;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_board, container, false);

        boardViewModel = new ViewModelProvider(this).get(BoardViewModel.class);
        binding.setBoardViewModel(boardViewModel);
        binding.setLifecycleOwner(this);
        inflateCells();

        return binding.getRoot();
    }


    @Override
    public void onCellClick(int row, int col, Card selectedCard) {
        if (selectedCard != null) {
            boardViewModel.playCard(row, col, selectedCard);
        } else {
            //todo
            // Muestra un mensaje para informar al usuario que no ha seleccionado una carta
        }
    }
    public static BoardFragment newInstance(DeckViewModel deckViewModel) {
        BoardFragment fragment = new BoardFragment();
        return fragment;
    }


    private void inflateCells() {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                FragmentCellBinding cellBinding = DataBindingUtil.inflate(
                        LayoutInflater.from(getContext()), R.layout.fragment_cell, binding.boardGrid, false);
                cellBinding.setOnCellClickListener(this);
                //TODO: Descomentar el codi quan cell tingui variable row y col.
                //cellBinding.setRow(row);
                //cellBinding.setCol(col);
                binding.boardGrid.addView(cellBinding.getRoot());
            }
        }
    }

}
