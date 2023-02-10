package vn.uit.dhomestay.interfaces;


import vn.uit.dhomestay.models.HomestayModel;

public interface Callback {
    void  onItemClick(int position, HomestayModel item);
}
