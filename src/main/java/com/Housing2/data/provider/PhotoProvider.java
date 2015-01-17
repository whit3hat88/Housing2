package com.Housing2.data.provider;

import com.Housing2.data.model.Photo;

// TODO: Auto-generated Javadoc

/**
 * The Class PhotoProvider.
 */
public class PhotoProvider extends BaseProvider<Photo> {

    /* (non-Javadoc)
     * @see com.Housing2.data.provider.BaseProvider#getEntityClass()
     */
    @Override
    protected Class<Photo> getEntityClass() {
        return Photo.class;
    }

    /**
     * Adds the photo.
     *
     * @param newPhoto the new photo
     */
    public void addPhoto(Photo newPhoto) {

        //TODO: Foto verkleinern/Dateityp anpassen etc?

        if (!super.save(newPhoto)) {

            System.out.println("Neues Foto konnte nicht in die Datenbank gespeichert werden!");

        }

    }

    /**
     * Removes the photo.
     *
     * @param photo the photo
     * @return true, if successful
     */
    public boolean removePhoto(Photo photo) {

        return super.delete(photo.getIdPhoto());

    }

    /**
     * Find by id.
     *
     * @param id the id
     * @return the photo
     */
    public Photo findById(Integer id) {
        return (Photo) super.find(id);
    }

}
