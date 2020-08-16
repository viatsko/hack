def rot13(secret_messages)
  decoded_messages = []

  secret_messages.each do |message|
    decoded_messages.push(message.tr!("abcdefghijklmnopqrstuvwxyz", "nopqrstuvwxyzabcdefghijklm"))
  end
end

