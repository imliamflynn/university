def extension_remover(file_name):
    extension = file_name.rfind(".")
    new = file_name[:extension]
    return new