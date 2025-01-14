// Autogenerated from Pigeon (v3.2.6), do not edit directly.
// See also: https://pub.dev/packages/pigeon

package tech.pylons.wallet;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MessageCodec;
import io.flutter.plugin.common.StandardMessageCodec;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/** Generated class from Pigeon. */
@SuppressWarnings({"unused", "unchecked", "CodeBlock2Expr", "RedundantSuppression"})
public class Pigeon {

  /** Generated class from Pigeon that represents data sent in messages. */
  public static class NFTMessage {
    private @NonNull String imageUrl;
    public @NonNull String getImageUrl() { return imageUrl; }
    public void setImageUrl(@NonNull String setterArg) {
      if (setterArg == null) {
        throw new IllegalStateException("Nonnull field \"imageUrl\" is null.");
      }
      this.imageUrl = setterArg;
    }

    /** Constructor is private to enforce null safety; use Builder. */
    private NFTMessage() {}
    public static final class Builder {
      private @Nullable String imageUrl;
      public @NonNull Builder setImageUrl(@NonNull String setterArg) {
        this.imageUrl = setterArg;
        return this;
      }
      public @NonNull NFTMessage build() {
        NFTMessage pigeonReturn = new NFTMessage();
        pigeonReturn.setImageUrl(imageUrl);
        return pigeonReturn;
      }
    }
    @NonNull Map<String, Object> toMap() {
      Map<String, Object> toMapResult = new HashMap<>();
      toMapResult.put("imageUrl", imageUrl);
      return toMapResult;
    }
    static @NonNull NFTMessage fromMap(@NonNull Map<String, Object> map) {
      NFTMessage pigeonResult = new NFTMessage();
      Object imageUrl = map.get("imageUrl");
      pigeonResult.setImageUrl((String)imageUrl);
      return pigeonResult;
    }
  }
  private static class CollectionsApiCodec extends StandardMessageCodec {
    public static final CollectionsApiCodec INSTANCE = new CollectionsApiCodec();
    private CollectionsApiCodec() {}
    @Override
    protected Object readValueOfType(byte type, ByteBuffer buffer) {
      switch (type) {
        case (byte)128:         
          return NFTMessage.fromMap((Map<String, Object>) readValue(buffer));
        
        default:        
          return super.readValueOfType(type, buffer);
        
      }
    }
    @Override
    protected void writeValue(ByteArrayOutputStream stream, Object value)     {
      if (value instanceof NFTMessage) {
        stream.write(128);
        writeValue(stream, ((NFTMessage) value).toMap());
      } else 
{
        super.writeValue(stream, value);
      }
    }
  }

  /** Generated class from Pigeon that represents Flutter messages that can be called from Java.*/
  public static class CollectionsApi {
    private final BinaryMessenger binaryMessenger;
    public CollectionsApi(BinaryMessenger argBinaryMessenger){
      this.binaryMessenger = argBinaryMessenger;
    }
    public interface Reply<T> {
      void reply(T reply);
    }
    static MessageCodec<Object> getCodec() {
      return CollectionsApiCodec.INSTANCE;
    }

    public void getCollection(Reply<List<NFTMessage>> callback) {
      BasicMessageChannel<Object> channel =
          new BasicMessageChannel<>(binaryMessenger, "dev.flutter.pigeon.CollectionsApi.getCollection", getCodec());
      channel.send(null, channelReply -> {
        @SuppressWarnings("ConstantConditions")
        List<NFTMessage> output = (List<NFTMessage>)channelReply;
        callback.reply(output);
      });
    }
  }
  private static Map<String, Object> wrapError(Throwable exception) {
    Map<String, Object> errorMap = new HashMap<>();
    errorMap.put("message", exception.toString());
    errorMap.put("code", exception.getClass().getSimpleName());
    errorMap.put("details", "Cause: " + exception.getCause() + ", Stacktrace: " + Log.getStackTraceString(exception));
    return errorMap;
  }
}
