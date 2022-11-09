package services;

import java.util.List;
import models.ChatLieu;

/**
 *
 * @author cvdoa
 */
public interface IChatLieuService {
    List<ChatLieu> getListSize();
    
    boolean save(ChatLieu cl);
    
    boolean delete(ChatLieu cl);
    
    ChatLieu getObject(String ma);
    
    List<ChatLieu> getSearch(String ten);
}